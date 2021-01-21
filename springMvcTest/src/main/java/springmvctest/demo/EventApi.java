package springmvctest.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventApi {

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event){
        return event;
    }
}
