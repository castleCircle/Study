package me.wony.springapplicationcontext;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Override
    public void a() {
        System.out.println("A");
    }

    @Override
    public void b() {
        System.out.println("B");
    }
}
