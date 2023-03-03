package com.example.mywebsite.utils;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * @author cls1277
 * @date 2022-11-28 19:29
 */
public class pbkdf2Utils {
    public static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    //盐的长度
    public static final int SALT_SIZE = 16;

    //生成密文的长度
    public static final int HASH_SIZE = 16;

    // 迭代次数
    public static final int PBKDF2_ITERATIONS = 1000;

    /**
     * 对输入的密码进行验证
     *  password 密码明文
     *  dataPassWord 密码加密
     */
    public static boolean pbkdf2Verify(String password, String dataPassWord)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // 用相同的盐值对用户输入的密码进行加密
        String result = getPBKDF2(password, dataPassWord.substring(0,16));
        // 把加密后的密文和原密文进行比较，相同则验证成功，否则失败
        return result.equals(dataPassWord.substring(16,dataPassWord.length()));
    }

    /**
     * 根据password和salt生成密文
     *
     */
    public static String getPBKDF2(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //将16进制字符串形式的salt转换成byte数组
        byte[] bytes = DatatypeConverter.parseHexBinary(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), bytes, PBKDF2_ITERATIONS, HASH_SIZE * 4);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);
        byte[] hash = secretKeyFactory.generateSecret(spec).getEncoded();
        //将byte数组转换为16进制的字符串
        return DatatypeConverter.printHexBinary(hash);
    }

    @Test
    public void testGet() throws NoSuchAlgorithmException, InvalidKeySpecException {
        String msg = new String("admin");
        String salt = Sha256Utils.getSha256Str(msg).substring(0, 16);
        String pbkdf2 = getPBKDF2(msg, salt);
        System.out.println("密文："+pbkdf2);
        String addsalt = salt + pbkdf2;
        System.out.println(pbkdf2Verify(msg, addsalt));
    }
}
