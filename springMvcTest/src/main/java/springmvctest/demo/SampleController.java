package springmvctest.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

//    @RequestMapping(value = "/hello" , method = {RequestMethod.GET,RequestMethod.PUT})
    @GetMapping("/events/{id}")
    @ResponseBody
    public Event hello(@PathVariable Integer id, @MatrixVariable String name){
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

}
