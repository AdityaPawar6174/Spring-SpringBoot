package com.aditya.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.aditya.*")
@EnableAspectJAutoProxy
// used for enabling support for handling component marked with AspectJ's
// @Aspect annotation, similar functionality found
public class AppConfig {
}
