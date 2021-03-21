package item3;

public enum EnumSingleTon {

    INSTANCE;

    private String name = "default";

    private EnumSingleTon() {
    }

    public EnumSingleTon getInstance() {
        return INSTANCE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
