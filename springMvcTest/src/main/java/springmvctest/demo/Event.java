package springmvctest.demo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

    private Integer id;

    @Min(0)
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    private String name;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
