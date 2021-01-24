package springmvctest.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@ControllerAdvice(assignableTypes = {EventController.class,EventApi.class})
//@RestControllerAdvice
public class BaseController {

    @ExceptionHandler({EventException.class,RuntimeException.class})
    public String eventErrorHandler(RuntimeException ex, Model model){
        model.addAttribute("message","runtime error");
        return "error";
    }
//
//    @ExceptionHandler
//    public String runtimeErrorHandler(RuntimeException e,Model model){
//        model.addAttribute("message","runtime error");
//        return "error";
//    }

    @InitBinder("event")
    public void initEventBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model){
        model.addAttribute("categories", Arrays.asList("study","seminar","hobby"));
    }

}
