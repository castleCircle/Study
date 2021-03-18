package item3;

enum OperationEnum {
    ADDITION, SUBTRACTION, MULTIPLICATION, DIVIDE;

    public double apply(double x, double y) {
        switch (this) {
            case ADDITION:
                return x + y;
            case SUBTRACTION:
                return x - y;
            case MULTIPLICATION:
                return x * y;
            default:
                throw new IllegalArgumentException();
        }
    }

}

public class SwithchEnum {
    public static void main(String[] args) {
        System.out.println(OperationEnum.ADDITION.apply(1, 2));
    }
}
