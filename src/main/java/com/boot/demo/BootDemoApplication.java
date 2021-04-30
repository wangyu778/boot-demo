package com.boot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wy
 * @date 2021.4.27
 */
@SpringBootApplication
@MapperScan(basePackages = "com.boot.demo.mapper")
public class BootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }

}
