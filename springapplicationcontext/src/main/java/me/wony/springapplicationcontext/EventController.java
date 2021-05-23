package me.wony.springapplicationcontext;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @InitBinder
    public void init(WebDataBinder webDataBinder){
//        webDataBinder.registerCustomEditor(Event.class,new EventEditor());
        webDataBinder.registerCustomEditor(Test.class,new TestEditor());
    }

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable Event event){
        System.out.println(event);
        return event.getId().toString();
    }

    @GetMapping("/test/{test}")
    public String getEvent(@PathVariable Test test){
        System.out.println(test);
        return test.getId().toString();
    }

}
