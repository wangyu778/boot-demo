package com.boot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.demo.entity.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author wy
 */
@Repository
public interface UserMapper extends BaseMapper<UserDao> {

//    /**
//     * 查
//     * @param userId userId
//     * @return UserDao
//     */
//    UserDao selectByPrimaryKey(String userId);

}