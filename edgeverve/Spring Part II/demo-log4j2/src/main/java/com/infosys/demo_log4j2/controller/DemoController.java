package com.infosys.demo_log4j2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("/")
    @ResponseBody
    public String testMethod(){
        logger.trace("this is a trace log example");
        logger.info("this is an info log example");
        logger.debug("this is a debug log example");
        logger.error("this is an error log example");
        logger.warn("this is a warn log example");

        return "Check the console log";
    }
}
