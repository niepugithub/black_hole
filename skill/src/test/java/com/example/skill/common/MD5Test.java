package com.example.skill.common;

import com.example.skill.common.utils.EnCrypt_And_deCryptUtil;
import com.mysql.cj.util.Base64Decoder;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 21:38
 **/
public class MD5Test {

    @Test
    public void test1() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b1 = md.digest("helloWorld".getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        String s = encoder.encode(b1);
        System.out.println(s);

        Base64Decoder decoder = new Base64Decoder();
        byte[] b = decoder.decode(s.getBytes(),0,s.length());
        System.out.println(new String(b));
    }

    @Test
    public void test2() throws Exception {
        String s = EnCrypt_And_deCryptUtil.encrypt_Base64("123");
        System.out.println(s);

        System.out.println(EnCrypt_And_deCryptUtil.decrypt_Base64(s));
    }
}
