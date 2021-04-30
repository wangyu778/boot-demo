package com.boot.demo.entity.dao;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * user
 * @author wy
 */
@Data
@TableName(value = "user")
public class UserDao implements Serializable {

    @TableField(value = "userId")
    @TableId(value = "userId")
    private String userId;

    @TableField(value = "userName")
    private String userName;

    @TableField(value = "password")
    private String password;

    @TableField(value = "createDate")
    private Date createDate;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    /**
     * 银行卡账号
     */
    @TableField(value = "idCardNumber")
    private String idCardNumber;

    /**
     * 个人介绍
     */
    @TableField(value = "personSign")
    private String personSign;

    /**
     * 是否租房
     */
    @TableField(value = "isRental")
    private Integer isRental;

    /**
     * 是否锁定
     */
    @TableField(value = "isLock")
    private Integer isLock;

    /**
     * 锁定时间
     */
    @TableField(value = "lockTime")
    private Date lockTime;

    private static final long serialVersionUID = 1L;
}