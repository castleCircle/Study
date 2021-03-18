package com.example.restfulwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/test")
    public String test() {

        TestBean t1 = new TestBean("1", "t1");
        TestBean t2 = new TestBean("1", "t2");
        TestBean t3 = new TestBean("2", "t3");
        TestBean t4 = new TestBean("2", "t4");
        TestBean t5 = new TestBean("3", "t5");

        ArrayList<TestBean> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);

        Map<String, ArrayList> map = new TreeMap<>();

        Map<String, List<TestBean>> collect = list.stream().collect(Collectors.groupingBy(TestBean::getCd));

        return "Hello";
    }

}
