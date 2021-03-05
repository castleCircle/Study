package item3;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum Operation{
    ADDITION, SUBRACTION , MULTIPLICATION , DIVIDE
}

public class Main {
    public static void main(String[] args) {

        EnumSet<Operation> set1,set2,set3,set4,set5;

        set1 = EnumSet.allOf(Operation.class);
        set2 = EnumSet.of(Operation.ADDITION,Operation.MULTIPLICATION);
        set3 = EnumSet.complementOf(set2);
        set4 = EnumSet.range(Operation.ADDITION,Operation.MULTIPLICATION);

        set5 = EnumSet.noneOf(Operation.class);
        set5.add(Operation.DIVIDE);
        set5.add(Operation.SUBRACTION);
        set5.remove(Operation.SUBRACTION);

        System.out.println("set1 = " + set1);
        System.out.println("set2 = " + set2);
        System.out.println("set3 = " + set3);
        System.out.println("set4 = " + set4);
        System.out.println("set5 = " + set5);

        List<Integer> time = IntStream.rangeClosed(0, 23).boxed().collect(Collectors.toList());
        List<Integer> collect = IntStream.rangeClosed(0, 23).boxed().collect(Collectors.toList());

    }
}
