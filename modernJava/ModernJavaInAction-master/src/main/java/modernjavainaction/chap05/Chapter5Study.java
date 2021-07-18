package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static modernjavainaction.chap04.Dish.menu;

public class Chapter5Study {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Moder", "Java", "In", "Action");
        List<Integer> collect = strings.stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect.toString());

        List<Integer> collect1 = menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(collect1);

        List<String> strings1 = Arrays.asList("Hello", "word");
        List<String> collect2 = strings1.stream().map(word -> word.split(""))
                .flatMap(t -> Arrays.stream(t))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect2);

        List<Integer> mapping = Arrays.asList(1,2,3,4,5);
        List<Integer> collect3 = mapping.stream().map(t -> t * t).collect(Collectors.toList());
        System.out.println(collect3.toString());

        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(3,4);

        //p166 2
        List<int[]> collect4 = a.stream().flatMap(i -> b.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
        collect4.forEach((t)-> {
            System.out.println(Arrays.toString(t));
        });

        System.out.println("=============");

        //p166 3번
        List<int[]> collect5 = a.stream().flatMap(i -> b.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        collect5.forEach((t)-> {
            System.out.println(Arrays.toString(t));
        });

        System.out.println("===");
        List<Stream<int[]>> collect6 = a.stream().map(i -> b.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        collect6.forEach((t)-> {
            t.forEach(tt->{
                System.out.println(Arrays.toString(tt));
            });
        });

        //p169
        System.out.println("=========[2021-07-18]=========");
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = someNumbers.stream().map(n -> n * n).filter(n -> n % 3 == 0).findFirst();
        if(first.isPresent()){
            System.out.println(first.get());
        }

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer reduce = integers.stream().reduce(3, (q, w) -> q + w);
        Optional<Integer> reduce1 = integers.stream().reduce((q, w) -> q + w);
        System.out.println(reduce);
        System.out.println(reduce1);

        System.out.println("=====");
        Optional<Integer> reduce2 = integers.stream().reduce(Integer::max);
        System.out.println(reduce2);

        System.out.println("===p173 Quiz==");
        Integer reduce3 = menu.stream().map(Dish::getName)
                .distinct()
                .map(t -> 1)
                .reduce(0, (aa, bb) -> aa + bb);
        System.out.println(reduce3);

        System.out.println("===p177 Quiz==");



    }

}
