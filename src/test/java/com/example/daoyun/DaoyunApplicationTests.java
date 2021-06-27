package com.example.daoyun;


import com.example.daoyun.util.SmsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootTest
class DaoyunApplicationTests {

    @Test
    public void sqldate(){
        DateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date currentDate = new java.util.Date(System.currentTimeMillis());
        System.out.println(time.format(currentDate));

    }


}
