package springmvctest.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("event")
public class EventController {

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", Arrays.asList("study","seminar","hobby"));
    }

//    @ModelAttribute("categories")
//    public List<String> categories(Model model){
//        return Arrays.asList("study","seminar","hobby");
//    }



    @GetMapping("/events/form/name")
    public String eventsFormName(Model model){
        model.addAttribute("event",new Event());
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/events/form-name";
        }
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event,Model model){
        model.addAttribute("event",event);
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event,
                                        BindingResult bindingResult,
                                        SessionStatus sessionStatus,
                                        RedirectAttributes attributes){
        if(bindingResult.hasErrors()){
            return "/events/form-limit";
        }
        sessionStatus.setComplete();
        attributes.addFlashAttribute("newEvent",event);
        return "redirect:/events/list";
    }


    @GetMapping("/events/list")
    public String getEvents(Model model,HttpSession httpSession){
        LocalDateTime visitTime = (LocalDateTime) httpSession.getAttribute("visitTime");

        Event newEvent = (Event)model.asMap().get("newEvent");

        Event event = new Event();
        event.setName("Spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(newEvent);
        eventList.add(event);

        model.addAttribute(eventList);
        return "/events/list";
    }

}
