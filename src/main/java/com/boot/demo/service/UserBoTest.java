package com.boot.demo.service;

import com.boot.demo.entity.bo.UserBO;
import com.boot.demo.entity.convert.UserConvert;
import com.boot.demo.entity.UserDO;
import com.boot.demo.entity.dao.UserDao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: wy
 * @Date: 2021/4/27 16:04
 * @Description:
 */
@Component
public class UserBoTest{


    public static void main(String[] args) {
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yaobang").setPassword("bushido");
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.toString());
    }

    public List<?> setListId(List<?> list){

        return list;
    }

}
