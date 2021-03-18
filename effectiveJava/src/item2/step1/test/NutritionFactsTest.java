package item2.step1.test;

public class NutritionFactsTest {

    private final int calories;
    private final int fat;
    private final int servingSize;
    private final int servings;

    static class Builder {
        private final int calories;
        private final int fat;
        private int servingSize;
        private int servings;

        public Builder(int calories, int fat) {
            this.calories = calories;
            this.fat = fat;
        }

        public Builder servingSize(int val) {
            this.servingSize = val;
            return this;
        }

        public Builder servings(int val) {
            this.servings = val;
            return this;
        }

        public NutritionFactsTest build() {
            return new NutritionFactsTest(this);
        }
    }

    public NutritionFactsTest(Builder builder) {
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
    }

    @Override
    public String toString() {
        return "NutritionFactsTest{" +
                "calories=" + calories +
                ", fat=" + fat +
                ", servingSize=" + servingSize +
                ", servings=" + servings +
                '}';
    }

    public static void main(String[] args) {
        NutritionFactsTest build = new Builder(1, 2).servings(3).build();
        System.out.println(build.toString());
    }

}
