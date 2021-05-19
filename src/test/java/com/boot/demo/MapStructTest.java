package com.boot.demo;

import com.boot.demo.entity.UserDO;
import com.boot.demo.entity.bo.UserBO;
import com.boot.demo.entity.convert.UserConvert;
import org.junit.jupiter.api.Test;

/**
 * @Author: wy
 * @Date: 2021/5/17 17:47
 * @Description:
 */
public class MapStructTest {

    @Test
    public void  mapStructChange(){
        UserDO userDO = new UserDO()
                .setId(1).setUsername("yaobang").setPassword("bushido");
        UserBO userBO = UserConvert.INSTANCE.convert(userDO);
        System.out.println(userBO.toString());
    }

}
