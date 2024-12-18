package epicode.it.pizzeria.entity.food_and_drink.pizza;

import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PizzaConfigurator {

    @Autowired
    @Qualifier("cheese")
    private Topping cheese;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    private ToppingRepo toppingRepo;

    @Bean
    @Scope("prototype")
    public Pizza getBase() {
        Pizza pizzaBase = new Pizza();
        pizzaBase.setName("Pizza Margherita");
        pizzaBase.setPrice(4.99);
        Topping cheese = toppingRepo.findByName("cheese");
        Topping tomato = toppingRepo.findByName("tomato");
        pizzaBase.getToppings().add(cheese);
        pizzaBase.getToppings().add(tomato);
        cheese.getPizzas().add(pizzaBase);
        tomato.getPizzas().add(pizzaBase);
        pizzaBase.setCalories(300 + cheese.getCalories() + tomato.getCalories());
        return pizzaBase;
    }


}
