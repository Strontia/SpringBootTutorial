package com.ygsoft.boot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类 相当于是所有启动的入口
 * @SpringBootApplication：相当于告诉SpringBoot，这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args){
        //启动的固定写法
//        SpringApplication.run(MainApplication.class, args);

        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names =  run.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }
}