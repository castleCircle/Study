package springmvctest.demo.thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class BeanUtilJava {

    public String returnValue(String bean){
        return "bean String :" + bean;
    }

}
