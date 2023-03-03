package com.example.mywebsite.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mywebsite.entity.User;
import com.example.mywebsite.mapper.UserMapper;
import com.example.mywebsite.utils.Sha256Utils;
import com.example.mywebsite.utils.pbkdf2Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;

/**
 * @author cls1277
 * @date 2022-10-01 22:29
 */
@RestController
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public List login(@RequestBody User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
//        map.put("password", user.getPassword());
        String password = user.getPassword();
        String salt = Sha256Utils.getSha256Str(password).substring(0, 16);
        System.out.println(salt);
        List<User> users = userMapper.selectByMap(map);
        String stdword = users.get(0).getPassword();
        String addsalt = salt + stdword;
        boolean isCorrect = pbkdf2Utils.pbkdf2Verify(password, addsalt);
        if(!isCorrect) {
            return null;
        }
        return users;
    }

    @GetMapping("/login")
    public List loginget(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        List<User> users = userMapper.selectByMap(map);
        return users;
    }
}
