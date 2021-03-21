package item3;

enum Fruit {
    APPLE("red") {
        public void print() {
            System.out.println("Apple color is red");
        }
    },
    BANANA("yello");

    private final String color;

    public String getColor() {
        return color;
    }

    public void print() {
        System.out.println("none");
    }

    Fruit(String color) {
        this.color = color;
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Fruit.APPLE);
        System.out.println(Fruit.APPLE.getColor());
        Fruit.APPLE.print();
        Fruit.BANANA.print();
    }
}
