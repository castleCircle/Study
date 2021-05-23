package me.wony.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ProxyTestServiceImpl implements TestService{

    @Autowired
    TestService testService;

    @Override
    public void a() {
        long l = System.currentTimeMillis();
        testService.a();
        System.out.println(System.currentTimeMillis()-l);
    }

    @Override
    public void b() {
        long l = System.currentTimeMillis();
        testService.b();
        System.out.println(System.currentTimeMillis()-l);
    }
}
