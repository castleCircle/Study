package me.wony.springapplicationcontext;

import me.wony.out.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringapplicationcontextApplication {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
//        SpringApplication.run(SpringapplicationcontextApplication.class);
        SpringApplication springApplication = new SpringApplication(SpringapplicationcontextApplication.class);
        springApplication.addInitializers((ApplicationContextInitializer<GenericApplicationContext>)ctx -> ctx.registerBean(MyService.class));
        springApplication.run(args);
    }

}
