package me.wony.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.format.support.DefaultFormattingConversionService;
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

    @Autowired
    DefaultFormattingConversionService conversionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
