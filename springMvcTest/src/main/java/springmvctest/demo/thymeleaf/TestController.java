package springmvctest.demo.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Model model){
        List<Test> list = new ArrayList<>();
        Test test1 = new Test("test1", 1, true);
        Test test2 =new Test("test2",2,false);
        Test test3 =new Test("test3",3,true);

        test2.setLists(Arrays.asList("number1","number2"));

        list.add(test1);
        list.add(test2);
        list.add(test3);


        model.addAttribute("data",list);
        model.addAttribute("test",1);

//        return "/view/test";
        return "index";
    }

    @GetMapping("/testGet")
    @ResponseBody
    public String testGet(@RequestParam String test){
        return "hello" + test;
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("body","body 입니다.");
        model.addAttribute("data","data 입니다.");
        return "/layout/index";
    }

    @GetMapping("/homeTest")
    public String homeTest(Model model){
        model.addAttribute("body","body 입니다.");
        model.addAttribute("data","data 입니다.");
        List<Test> list = new ArrayList<>();
        Test test1 = new Test("test1", 1, true);
        Test test2 =new Test("test2",2,false);
        Test test3 =new Test("test3",3,true);

        test2.setLists(Arrays.asList("number1","number2"));

        list.add(test1);
        list.add(test2);
        list.add(test3);


        model.addAttribute("datas",list);
        return "/layouttest/index";
    }

    @GetMapping("/ho")
    public String ho(){
        return "/views/common/content";
    }


}
