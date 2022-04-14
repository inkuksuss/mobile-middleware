package com.middleware.mobile.web.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

@Slf4j
@Component
public class PasswordEncoder {

    private static String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static String KEY;

    @Value("${password.key}")
    public void setKey(String key) {
        this.KEY = key;
    }

    public static String getRandomString(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(new Random().nextInt(chars.length())));
        return sb.toString();
    }

    public static String encrypt(String str) throws Exception {
        final String iv = PasswordEncoder.getRandomString(16);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));

        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        return Base64.getEncoder().encodeToString(iv.getBytes()) + ":" + Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
    }

    public static String decrypt(String str) throws Exception {
        String sp[] = str.split(":");
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY.getBytes(), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.getDecoder().decode(sp[0]));

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);

        return new String(cipher.doFinal(Base64.getDecoder().decode(sp[1])), "UTF-8");
    }

}
