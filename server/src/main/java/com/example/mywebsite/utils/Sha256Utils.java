package com.example.mywebsite.utils;

import org.jetbrains.annotations.TestOnly;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author cls1277
 * @date 2022-10-03 20:42
 */
public class Sha256Utils {

    @Test
    public void testSha256() {
        System.out.println(getSha256Str("cls1277"));
        System.out.println(getSha256Str("cls1277").substring(0, 16));
    }

    public static String getSha256Str(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
}
