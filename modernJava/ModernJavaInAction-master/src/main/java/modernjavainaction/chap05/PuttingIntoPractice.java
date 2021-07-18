package modernjavainaction.chap05;

import org.apache.commons.math3.geometry.partitioning.BSPTree;
import scala.Int;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

  public static void main(String... args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    //p177 1번
    System.out.println("====TEST START====");
    System.out.println("1.");
    List<Transaction> collect = transactions.stream()
            .filter(t -> t.getYear() == 2011)
            .sorted(comparing(Transaction::getValue))
            .collect(toList());
    System.out.println(collect.toString());

    System.out.println("2.");
    List<String> collect1 = transactions.stream()
            .map(t->t.getTrader().getCity())
            .distinct().collect(toList());
    System.out.println(collect1);

    System.out.println("3.");
    List<Trader> cambridge = transactions.stream()
            .map(t -> t.getTrader())
            .filter(t -> t.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .collect(toList());

    System.out.println(cambridge.toString());

    System.out.println("4.");
    String str4 = transactions.stream().map(t -> t.getTrader().getName())
            .distinct()
            .sorted()
            .reduce("", (n1, n2) -> n1 + " " +n2);
    System.out.println(str4);

    System.out.println("5.");
    boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
    System.out.println(milan);

    System.out.println("6.");
    transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
            .map(t -> t.getValue())
            .forEach(System.out::println);


    System.out.println("7.");
    Optional<Integer> max = transactions.stream().map(t -> t.getValue()).max(Integer::compareTo);
    Integer max1 = transactions.stream().map(t -> t.getValue()).reduce(0,Integer::max);
    System.out.println(max);
    System.out.println(max1);

    System.out.println("8.");

    Optional<Transaction> min = transactions.stream().min(comparing(Transaction::getValue));
    System.out.println(min.map(String::valueOf).orElse("No transaction"));


    System.out.println("====TEST END====");

    // 질의 1: 2011년부터 발생한 모든 거래를 찾아 값으로 정렬(작은 값에서 큰 값).
    List<Transaction> tr2011 = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2011)
        .sorted(comparing(Transaction::getValue))
        .collect(toList());
    System.out.println(tr2011);

    // 질의 2: 거래자가 근무하는 모든 고유 도시는?
    List<String> cities = transactions.stream()
        .map(transaction -> transaction.getTrader().getCity())
        .distinct()
        .collect(toList());
    System.out.println(cities);

    // 질의 3: Cambridge의 모든 거래자를 찾아 이름으로 정렬.
    List<Trader> traders = transactions.stream()
        .map(Transaction::getTrader)
        .filter(trader -> trader.getCity().equals("Cambridge"))
        .distinct()
        .sorted(comparing(Trader::getName))
        .collect(toList());
    System.out.println(traders);

    // 질의 4: 알파벳 순으로 정렬된 모든 거래자의 이름 문자열을 반환 
    String traderStr = transactions.stream()
        .map(transaction -> transaction.getTrader().getName())
        .distinct()
        .sorted()
        .reduce("", (n1, n2) -> n1 + n2);
    System.out.println(traderStr);

    // 질의 5: Milan에 거주하는 거래자가 있는가?
    boolean milanBased = transactions.stream()
        .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    System.out.println(milanBased);

    // 질의 6: Cambridge에 사는 거래자의 모든 거래내역 출력.
    transactions.stream()
        .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
        .map(Transaction::getValue)
        .forEach(System.out::println);

    // 질의 7: 모든 거래에서 최고값은 얼마인가?
    int highestValue = transactions.stream()
        .map(Transaction::getValue)
        .reduce(0, Integer::max);
    System.out.println(highestValue);

    // 가장 작은 값을 가진 거래 탐색
    Optional<Transaction> smallestTransaction = transactions.stream()
        .min(comparing(Transaction::getValue));
    // 거래가 없을 때 기본 문자열을 사용할 수 있도록발견된 거래가 있으면 문자열로 바꾸는 꼼수를 사용함(예, the Stream is empty)
    System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
  }

}
