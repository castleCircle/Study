package modernjavainaction.chap04;

import static java.util.stream.Collectors.toList;
import static modernjavainaction.chap04.Dish.menu;

import java.util.List;
import java.util.stream.Collectors;

public class HighCaloriesNames {

  public static void main(String[] args) {
    List<String> names = menu.stream()
        .filter(dish -> {
          System.out.println("filtering " + dish.getName());
          return dish.getCalories() > 300;
        })
        .map(dish -> {
          System.out.println("mapping " + dish.getName());
          return dish.getName();
        })
        .limit(3)
        .collect(toList());
    System.out.println(names);

      System.out.println("===================");
      List<Dish> collect = menu.stream().filter(t -> t.getCalories() > 400).collect(toList());
      System.out.println(collect.toString());

      List<Dish> collect1 = menu.stream().takeWhile(t -> t.getCalories() > 400).collect(toList());
      System.out.println(collect1.toString());

      List<Dish> collect2 = menu.stream().dropWhile(t -> t.getCalories() > 400).collect(toList());
      System.out.println(collect2.toString());


      List<Dish> collect3 = menu.stream()
              .filter(d -> d.getType() == Dish.Type.MEAT)
              .limit(2)
              .collect(toList());

      System.out.println(collect3.toString());


      


  }

}
