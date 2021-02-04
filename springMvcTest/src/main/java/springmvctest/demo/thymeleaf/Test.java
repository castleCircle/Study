package springmvctest.demo.thymeleaf;

public class Test {

    String name;
    Integer age;
    Boolean bool;

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Test(String name, Integer age, Boolean bool) {
        this.name = name;
        this.age = age;
        this.bool = bool;
    }
}
