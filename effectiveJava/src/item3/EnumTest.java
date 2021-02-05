package item3;

import static item3.DisplayType.*;

enum DisplayType{
    LED("Light emitting diode"),
    OLED("Organic Light Emitting Diode"),
    TEST("TEE","ds");

    private final String key;

    public String getKey() {
        return key;
    }

    DisplayType(String key) {
        this.key = key;
    }

    DisplayType(String key,String a) {
        this.key = key;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(DisplayType.OLED);
        System.out.println(DisplayType.OLED.getKey());
        System.out.println(DisplayType.TEST.getKey());
    }
}
