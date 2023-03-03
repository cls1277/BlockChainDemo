package com.example.mywebsite.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mywebsite.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cls1277
 * @date 2022-10-01 23:39
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
