package item3;

enum Direction{
    EAST("east is good") {
        public void getDirection(){
            System.out.println("east");
        }
    },
    WEST("west is good") {
        public void getDirection(){
            System.out.println("west");
        }
    };

    private final String key;
    public String getKey() {
        return key;
    }

    private Direction(String str){
        this.key = str;
    }
}

public class DirectionTest {
    public static void main(String[] args) {
        System.out.println(Direction.EAST);
        System.out.println(Direction.EAST.getKey());
        System.out.println(Direction.EAST.getDirection());
    }
}
