package com.boot.demo.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: wy
 * @Date: 2021/4/27 15:54
 * @Description: 用户数据库DO
 */
@Data
@Accessors(chain = true)
public class UserBO {

    private Integer id;

    private String username;

    private String password;

}
