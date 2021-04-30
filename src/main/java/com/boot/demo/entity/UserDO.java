package com.boot.demo.entity;

import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Author: wy
 * @Date: 2021/4/27 15:54
 * @Description: 用户数据库DO
 */
@Data
@Accessors(chain = true)
public class UserDO {

    private Integer id;

    private String username;

    private String password;

}
