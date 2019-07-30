package com.demo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.demo.mapper")
@SpringBootApplication
@EnableDubbo
public class ProviderTest {
    public static void main(String[] args) {
        SpringApplication.run(ProviderTest.class,args);
    }
}
