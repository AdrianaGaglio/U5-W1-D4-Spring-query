package epicode.it.pizzeria.entity.food_and_drink.pizza;

import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class PizzaRunner implements ApplicationRunner {
private final PizzaService pizzaService;



    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {


            pizzaService.createStandardPizzas();


    }
}
