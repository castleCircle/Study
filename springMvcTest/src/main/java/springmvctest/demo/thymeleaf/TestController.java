package springmvctest.demo.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model){
        List<Test> list = new ArrayList<>();
        list = Arrays.asList(new Test("test1",1,true),new Test("test2",2,false)
                ,new Test("test3",3,true));
        model.addAttribute("data",list);
        model.addAttribute("test",1);
        return "/views/test";
    }

    @GetMapping("/testGet")
    @ResponseBody
    public String testGet(){
        return "hello";
    }


}
