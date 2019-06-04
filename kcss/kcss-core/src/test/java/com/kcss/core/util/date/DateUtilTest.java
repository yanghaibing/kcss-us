package com.kcss.core.util.date;

import com.kcss.core.config.CoreConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CoreConfig.class})
public class DateUtilTest {

    @Test
    public void daysBetweenTest() {
        Date start, end;

        start = Date.from(LocalDateTime.of(2017, 1, 1, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        end = Date.from(LocalDateTime.of(2017, 1, 1, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        Assert.assertEquals(0, DateUtil.daysBetween(start, end));

        start = Date.from(LocalDateTime.of(2017, 1, 1, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        end = Date.from(LocalDateTime.of(2017, 1, 2, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        Assert.assertEquals(1, DateUtil.daysBetween(start, end));

        start = Date.from(LocalDateTime.of(2017, 1, 2, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        end = Date.from(LocalDateTime.of(2017, 1, 1, 9, 0).atZone(ZoneId.systemDefault()).toInstant());
        Assert.assertEquals(-1, DateUtil.daysBetween(start, end));
    }

}
