package com.example.restfulwebservice.helloworld;

public class TestBean {
    public String cd;
    public String name;

    public String getCd() {
        return cd;
    }

    public void setCd(String cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean(String cd, String name) {
        this.cd = cd;
        this.name = name;
    }
}
