package springmvctest.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matcher.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception{
        MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("/events/form"))
                .andExpect(model().attributeExists("event")).andReturn().getRequest();

        Object event = request.getSession().getAttribute("event");
        System.out.println(event);

    }


    @Test
    public void helloTest() throws Exception{
//        mockMvc.perform(post("/events?name=keesun"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("name").value("keesun"));

        ResultActions result = mockMvc.perform(post("/events").param("name", "keesun").param("limit", "-10"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(model().hasErrors());

        ModelAndView mav = result.andReturn().getModelAndView();
        Map<String, Object> model = mav.getModel();
        System.out.println(model.size());
    }

    @Test
    public void getEvents() throws Exception{

        Event event = new Event();
        event.setName("Winter");
        event.setLimit(10000);

        mockMvc.perform(get("/events/list").sessionAttr("visitTime", LocalDateTime.now()).flashAttr("newEvent",event))
                .andDo(print()).andExpect(status().isOk()).andExpect(xpath("//p").nodeCount(2));

    }

}