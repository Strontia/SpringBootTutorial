package com.ygsoft.boot.config;

import com.ygsoft.boot.bean.Pet;
import com.ygsoft.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 配置类本身也是组件
 * proxyBeanMethods: 代理bean的方法
 * Full（proxyBeanMethods = true）配置和Lite（调成False）配置，可以解决组件依赖的问题
 *
 */
//@Configuration //告诉SpringBoot这是一个配置类，等同于以前的配置文件
@Configuration(proxyBeanMethods = true) //
public class MyConfig {

    /**
     * 外部无论文配置类中的这个组件注册方法调用多少次，获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值就是组件在容器中的实例。
    public User user01(){
        return new User("wpw", 18);
    }

    @Bean
//    @Bean("BadCat") //可以在括号内给组件起自定义的名字
    public Pet cat(){
        return new Pet("tomcat");
    }
}

