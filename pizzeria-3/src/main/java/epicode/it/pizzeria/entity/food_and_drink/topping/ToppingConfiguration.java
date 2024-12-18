package epicode.it.pizzeria.entity.food_and_drink.topping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToppingConfiguration {

    @Autowired
    private ToppingRepo toppingRepo;

    @Bean(name="cheese")
    public Topping getCheese() {
        Topping cheese = new Topping();
        cheese.setName("cheese");
        cheese.setPrice(0.69);
        cheese.setCalories(92);
        return cheese;
    }

    @Bean(name="tomato")
    public Topping getTomato() {
        Topping tomato = new Topping();
        tomato.setName("tomato");
        tomato.setPrice(0.69);
        tomato.setCalories(25);
        return tomato;
    }

    @Bean(name="ham")
    public Topping getHam() {
        Topping ham = new Topping();
        ham.setName("ham");
        ham.setPrice(0.99);
        ham.setCalories(35);
        return ham;
    }

    @Bean(name="onions")
    public Topping getOnions() {
        Topping onions = new Topping();
        onions.setName("onions");
        onions.setPrice(0.69);
        onions.setCalories(22);
        return onions;
    }

    @Bean(name="pineapple")
    public Topping getPineapple() {
        Topping pineapple = new Topping();
        pineapple.setName("pineapple");
        pineapple.setPrice(0.79);
        pineapple.setCalories(24);
        return pineapple;
    }

    @Bean(name="salami")
    public Topping getSalami() {
        Topping salami = new Topping();
        salami.setName("salami");
        salami.setPrice(0.99);
        salami.setCalories(86);
        return salami;
    }

    @Bean(name="tuna")
    public Topping getTuna() {
        Topping tuna = new Topping();
        tuna.setName("tuna");
        tuna.setPrice(1.29);
        tuna.setCalories(120);
        return tuna;
    }
}
