package item2.step1;

public class Main {

    public static void main(String[] args) {
        NutritionFacts build = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(build.toString());
    }

}
