package modernjavainaction.chap06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static modernjavainaction.chap06.GroupingTransactions.transactions;

public class MainClass {

    public static void main(String[] args) {

        Map<GroupingTransactions.Currency, List<GroupingTransactions.Transaction>> collect = null;
        collect = transactions.stream().collect(Collectors.groupingBy(GroupingTransactions.Transaction::getCurrency));

        Integer collect1 = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(collect1);

        Double collect2 = Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(collect2);

        String collect3 = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(collect3);

        String collect4 = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(collect4);

        Integer collect5 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(collect5);

        Integer collect6 = Dish.menu.stream().collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect6);

        Optional<Integer> reduce = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum);
        Integer integer = reduce.orElse(0);
        System.out.println(integer);

        Map<Grouping.CaloricLevel, List<Dish>> collect7 = Dish.menu.stream().collect(Collectors.groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return Grouping.CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return Grouping.CaloricLevel.NORMAL;
            } else {
                return Grouping.CaloricLevel.FAT;
            }
        }));
        System.out.println(collect7);

        Map<Dish.Type, List<Dish>> collect9 = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));

        Map<Dish.Type, List<String>> collect8 = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(collect8);

        Map<Dish.Type, Long> collect10 = Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(collect10);

        Map<Boolean, List<Dish>> collect11 = Dish.menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(collect11);


        IntStream.range(0,5).forEach(i-> System.out.println(i));
        System.out.println("=======");
        IntStream.range(0,5).boxed().forEach(i-> System.out.println(i));

        Stream<Integer> boxed = IntStream.range(0, 5).boxed();
        IntStream range = IntStream.range(0, 5);;
        System.out.println("====================");
        IntStream.rangeClosed(0,5).forEach(i-> System.out.println(i));

        Integer collect12 = Dish.menu.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println(collect12);

        Map<Boolean, List<Integer>> collect13 = IntStream.rangeClosed(2, 10).boxed().collect(Collectors.partitioningBy(candidate -> PartitionPrimeNumbers.isPrime(candidate)));



    }

    public static Supplier<List<T>> supplier(){
        return ()->new ArrayList<T>();
    }

}
