package epicode.it.pizzeria.entity.food_and_drink.topping;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class ToppingRunner implements ApplicationRunner {
private final ToppingService toppingService;


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
            toppingService.saveAll();
    }
}
