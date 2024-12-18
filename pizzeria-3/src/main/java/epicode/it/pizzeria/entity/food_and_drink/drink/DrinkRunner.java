package epicode.it.pizzeria.entity.food_and_drink.drink;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class DrinkRunner implements ApplicationRunner {
    private final DrinkService drinkService;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        drinkService.createAllDrinks();
    }
}
