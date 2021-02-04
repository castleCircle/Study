package item2.step2.test;

import java.util.Objects;

public class NyPizzaT extends PizzaT{

    private final SizeEnum size;

    static class Builder extends PizzaT.Builder{
        private final SizeEnum size;
        public Builder(SizeEnum size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        PizzaT build() {
            return new NyPizzaT(this);
        }

        @Override
        public Builder self() {
            return this;
        }
    }


    public NyPizzaT(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static void main(String[] args) {
        PizzaT build = new Builder(SizeEnum.SMALL)
                .addTopping(ToppingEnum.ONION)
                .addTopping(ToppingEnum.SAUSAGE)
                .build();
        System.out.println(build);
    }

}
