package com.boot.demo;

import com.alibaba.fastjson.JSONObject;
import com.boot.demo.entity.UserDO;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: wy
 * @Date: 2021/5/7 10:35
 * @Description:
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String ,String> redisTemplate;

    @Test
    public String testRedis(){
//        redisTemplate.opsForValue().set("test", "1");
//        System.out.println(stringRedisTemplate.opsForValue().get("test"));

//        UserDO userDO = new UserDO()
//                .setId(1)
//                .setUsername("123")
//                .setPassword("123456");
//        String key = "userId : %d" + userDO.getId();

        String str = "aaa";
        System.out.println(str);
        return str;

    }

    @Test
    public void testRestSerializer() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String key = String.format("user:%d", 1);
        System.out.println(redisTemplate.opsForValue().get(key));

        Class<?> clazz = this.getClass();
        Method testRedis = clazz.getMethod("testRedis");
        Object invoke = testRedis.invoke(this);
        System.out.println(invoke);

    }

}
