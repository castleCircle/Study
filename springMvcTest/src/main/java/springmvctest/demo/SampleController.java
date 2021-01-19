package springmvctest.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model){
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event",newEvent);
        return "/events/form";
    }

    @PostMapping("/events")
    @ResponseBody
    public Event getEvent(@Validated(Event.ValidateName.class) @ModelAttribute Event event, BindingResult bindingResult){
        //Map<String, String> params
        if(bindingResult.hasErrors()){
            System.out.println("========================");
            bindingResult.getAllErrors().forEach(c->{
                System.out.println(c.toString());
            });
        }
        return event;
    }

}
