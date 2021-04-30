package com.boot.demo.entity.convert;

import com.boot.demo.entity.bo.UserBO;
import com.boot.demo.entity.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author: wy
 * @Date: 2021/4/27 16:01
 * @Description: 类型转换
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * 类型转换
     * @param userDO dao
     * @return business
     */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password")
    })
    UserBO convert(UserDO userDO);

}
