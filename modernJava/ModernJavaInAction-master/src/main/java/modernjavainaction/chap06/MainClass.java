package modernjavainaction.chap06;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    }

}
