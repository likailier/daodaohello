package com.example.daoyun.util;


import redis.clients.jedis.Jedis;

public class JedisUtil {

    private static Jedis jedis;

    private static void init(){
        jedis = new Jedis("139.224.2.119",6379);
    }

    public static void setVerifycode(String phone,String verifycode){
        int second = 120;
        JedisUtil.init();
        jedis.set(phone,verifycode);
        jedis.expire(phone,second);
    }

    public static String getVerifycode(String phone){
        JedisUtil.init();
        return jedis.get(phone);
    }

    public static void deleteVerifycode(String phone){
        if (jedis.get(phone) !=null){
            jedis.del(phone);
        }
    }
}
