package item2.step2.test;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class PizzaT {

    final private Set<ToppingEnum> toppings;

    abstract static class Builder{
        EnumSet<ToppingEnum> toppings = EnumSet.noneOf(ToppingEnum.class);

        public Builder addTopping(ToppingEnum toppingEnum){
            toppings.add(Objects.requireNonNull(toppingEnum));
            return self();
        }

        abstract PizzaT build();

        public abstract Builder self();
    }

    public PizzaT(Builder builder){
        this.toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        return "PizzaT{" +
                "toppings=" + toppings +
                '}';
    }
}
