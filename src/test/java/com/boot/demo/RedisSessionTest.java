package com.boot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wy
 * @Date: 2021/5/17 11:07
 * @Description:
 */
@SpringBootTest
public class RedisSessionTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void sessionTest(){

        String testValue = redisTemplate.execute(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i < 100; i++) {
                    operations.opsForValue().set(String.format("yunai:%d", i), "shuai02");
                }
                return (String) operations.opsForValue().get(String.format("yunai:%d", 0));
            }
        });

        System.out.println("result:" + testValue);

    }

}
