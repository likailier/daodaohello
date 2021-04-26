package com.example.daoyun;


import com.example.daoyun.util.SmsUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class DaoyunApplicationTests {

    @Test
    public void setss(){
        Jedis jedis = new Jedis("139.224.2.119",6379);
        jedis.set("name","zlw");
    }


}
