package me.wony.springapplicationcontext;

import org.springframework.stereotype.Service;

@Service
public class SimpleEventService implements EventService{

    @Override
    public void createEvent() {

//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Created an event");

//        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void publishEvent() {
//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Publishedan event");

//        System.out.println(System.currentTimeMillis() - begin);
    }

    public void deleteEvent(){
        System.out.println("Delete an event");
    }
}
