package com.kcss.core.util.security;

import org.apache.log4j.Logger;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PasswordEncryptor {

    private TextEncryptor textEncryptor;
    protected static Logger logger = Logger.getLogger(PasswordEncryptor.class);
    @PostConstruct
    private void init() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("eyJhbGciOiJIUzUxMiJ9");
        this.textEncryptor = textEncryptor;
    }

    public String encrypt(String text) {
        return textEncryptor.encrypt(text);
    }

    public String decrypt(String text) {
        return textEncryptor.decrypt(text);
    }

    public boolean matches(String text, String encryptedText) {
        return text.equals(decrypt(encryptedText));
    }

}

