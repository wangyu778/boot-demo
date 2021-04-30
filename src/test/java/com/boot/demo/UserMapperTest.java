package com.boot.demo;

import com.boot.demo.entity.dao.UserDao;
import com.boot.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wy
 * @Date: 2021/4/29 15:09
 * @Description:
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect(){
        UserDao userDao = userMapper.selectById("admin");
        System.out.println(userDao.toString());
    }

}
