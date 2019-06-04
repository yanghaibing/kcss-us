package com.kcss.core.util.security;

import com.kcss.core.config.CoreConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CoreConfig.class})
public class PasswordEncryptorTest {

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @Test
    public void encryptTest() {
        System.out.println(passwordEncryptor.encrypt("123456"));
    }

    @Test
    public void decryptTest() {
        System.out.printf(passwordEncryptor.decrypt("XXX"));
    }

    @Test
    public void decryptMSTest(){
        String s = "----- ----- ----- ----- ...-- ----- .---- ----- ----- ----- ----- ----- ...-- \n" +
                "----- ----- ----- ----- ----- ----- ----- ...-- ----- ..--- ----- ----- ----- \n" +
                "----- ----- ...-- ----- ....- ----- ----- ----- ----- ----- ..--- ----- ...-- \n" +
                ".---- ----- ----- ----- ----- -.... ----- ...-- ----- ----- ----- ----- ----- \n" +
                "-.... ----- ....- ..--- ----- ----- ----- ----- -.... ----- ...-- ..--- --... \n" +
                "----- ----. ----- ..... ----- ...-- ..--- ....- ----- ....- ..--- -.... ----- \n" +
                "----- ----- ---.. ----- ..--- ----- ---.. ----- ..--- ----- -.... ----- ..... \n" +
                "----- ...-- .---- ..... ----- ..... ----- ....- ..--- ...-- .---- ..... ...-- \n" +
                "....- ----- ...-- .---- ..... ----- ----- -----";
        Map<String,String> map = new HashMap<String,String>(){{
            put(".----","1");
            put("..---","2");
            put("...--","3");
            put("....-","4");
            put(".....","5");
            put("-....","6");
            put("--...","7");
            put("---..","8");
            put("----.","9");
            put("-----","0");
        }};

        map.keySet().forEach(key->{
            String s2 = s.replaceAll(key,map.get(key)).toString();
            System.out.print(s2);

        });



    }


}
