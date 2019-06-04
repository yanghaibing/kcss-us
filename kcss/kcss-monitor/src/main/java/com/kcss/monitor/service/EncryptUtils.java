package com.kcss.monitor.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class EncryptUtils {
    public static String encryptSha256(String str) {
        try {
            return DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256")
                    .digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
