package me.wony.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


@Component
public class AppRunner implements ApplicationRunner {

//    @Autowired
//    Validator validate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Event event = new Event();
        EventValidator eventValidator = new EventValidator();
        Errors errors = new BeanPropertyBindingResult(event,"event1");
        eventValidator.validate(event,errors);
//        validate.validate(event,errors);
        errors.getAllErrors().forEach(e->{
            System.out.println("=====error code=====");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });

        Test test = new Test();
        TestValidator testValidator = new TestValidator();
        Errors errors1 = new BeanPropertyBindingResult(test,"event2");
        testValidator.validate(test,errors1);

        errors1.getAllErrors().forEach(e->{
            System.out.println("=====errors code=====");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }
}
