package com.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author: wy
 * @Date: 2021/4/29 17:59
 * @Description:
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/debug")
    public void debug() {
        System.out.println(logger.isInfoEnabled());
        logger.info("[数据了]");
        logger.debug("debug");
    }

    @GetMapping("/info")
    public void info() {
        System.out.println(logger.isInfoEnabled());
        logger.info("info");
    }

    @GetMapping("/error")
    public void error() {
        System.out.println(logger.isInfoEnabled());
        logger.error("error");
    }

}
