package com.ygsoft.boot;


import com.ygsoft.boot.bean.Pet;
import com.ygsoft.boot.bean.User;
import com.ygsoft.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 主程序类 相当于是所有启动的入口
 * @SpringBootApplication：相当于告诉SpringBoot，这是一个SpringBoot应用，其实是一个合成注解，相当于三个注解
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan
 * @SpringBootApplication(scanBasePackages="com.ygsoft"): 规定扫描的基础包范围，这样Controller程序不放在默认的包结构中也可以生效
 * @ComponentScan(""): 也可以用这个指定扫描路径，但和@SpringBootApplication注解冲突
 */
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
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

        //3.从容器中获取组件
//        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        //注意，获取的组件名是Config中定义的方法名
        Pet badCat01 = run.getBean("cat", Pet.class);
        Pet badCat02 = run.getBean("cat", Pet.class);

        System.out.println("组件: " + (badCat01 == badCat02));

        //配置类也是一个组件
        MyConfig bean  = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。如果有就不会新建
        //true属性保持组件单实例，改成false就不是了
        User user = run.getBean("user01", User.class);
        User user1 = run.getBean("user01", User.class);

        System.out.println("User组件 = " + (user == user1));




    }
}
