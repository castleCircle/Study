package springmvctest.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class SampleController {

//    @RequestMapping(value = "/hello" , method = {RequestMethod.GET,RequestMethod.PUT})
    @PostMapping("/events")
    @ResponseBody
    public Event hello(@RequestParam String name,@RequestParam Integer limit){
        //Map<String, String> params
        Event event = new Event();
        event.setName(name);
        event.setLimit(limit);
        return event;
    }

}
