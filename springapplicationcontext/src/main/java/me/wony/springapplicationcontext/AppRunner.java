package me.wony.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    TestService testService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        testService.a();
        testService.b();
    }
}
