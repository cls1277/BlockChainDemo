package com.example.mywebsite.utils;

import org.junit.Test;

/**
 * @author cls1277
 * @date 2022-10-04 16:03
 */
public class StringUtils {

    public static String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    public static String getBack(String str, String back) {
        String t = reverse(str);
        return reverse(t.substring(back.length()+2));
    }

    @Test
    public void testString() {
        String a = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMF5i7ihLt63MWfk\n" +
                "E2zz2hYub401cz8a9pzDzAiltfbQDfQxUlVEiKqErDE3XCOVu7GFPrX61OaTqYXf\n" +
                "YM7urivwEbB38fm6Bj8a3IjSy67ch9LqL6jHAy7JwUwLVtSbopXG6efy3CothL1v\n" +
                "EeRj7/1GIs6Dy75DjKtK9r3/t+vZAgMBAAECgYEAvxDas/WxxM5jYzbxHCrhmAA5\n" +
                "t9kuPAbTvtL53xxPTDQBY8OFjKGG2eb16hDC1H2dg12UJcFVmXP/+S41e4Zox1Gv\n" +
                "AGFJVz/Wx15bKXSsvLbLe2FsFLqhWdhhxHkuihwj4DSyUN4FHllsPuuRB6Xd4JtS\n" +
                "efLoM9LiDc9nM2N31IECQQDklxRHwL8uuygFQrV1PU1WK9oXeC0zG7NmhHLsYW7V\n" +
                "LlvmTGDJSTSwXjWLv71sBWJXm2KGYWybH+pneVQ+1/ERAkEA2KyMGrMVaefErRyl\n" +
                "BzNEEAgRiHqt2j9Yot7Q59r1T7xJ8zY1rNDK+UILIlfW2/woVoJeooPG+dULNqco\n" +
                "3aFOSQJAbE30iuaU7oQ4Ov3XUbwAx2Ixi8shx0RJpLn+ZWboh1LWse/gL55iu2l3\n" +
                "f0YSbnrClHWHodnJBlqByhLfSoMvsQI/YHx1523YG1EaQ/x9gLdTl8///saipI2Q\n" +
                "6vZOEPFwTBGM3MFHJa3UtSqzypdTFqMzU1K60aPc92Pnmm7Vw9wRAkEA3B5i7uEG\n" +
                "Ha5F2NQrAaL9GBO3QSByaKVqw5vZvsN63NpX2f47lfAau/X6uQW9pnMzDkdOtF5n\n" +
                "ZjVtWkOG4asL9w==\n" +
                "-----END PRIVATE KEY-----";
        System.out.println(getBack(a, "-----END PRIVATE KEY-----"));
    }
}
