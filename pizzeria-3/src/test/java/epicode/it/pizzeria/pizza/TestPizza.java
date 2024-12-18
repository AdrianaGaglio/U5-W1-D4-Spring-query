package epicode.it.pizzeria.pizza;

import com.github.javafaker.Faker;
import epicode.it.pizzeria.entity.food_and_drink.pizza.Pizza;
import epicode.it.pizzeria.entity.food_and_drink.pizza.PizzaService;
import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingService;
import epicode.it.pizzeria.utilities.Utilities;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestPizza {
    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private ToppingService toppingService;

    @Autowired
    private Faker faker;

    @Test
    @DisplayName("Test creazione pizza")
    public void testCreatePizza() {
        int existingPizza = pizzaService.countPizza();
        Pizza newPizza = new Pizza();
        newPizza.setName("pizza di test");
        newPizza=pizzaService.save(newPizza);

        int updatedPizza = pizzaService.countPizza();

        assertEquals(existingPizza+1,updatedPizza);

        Pizza createdPizza = pizzaService.findById(newPizza.getId());

        assertEquals(newPizza.getName(),createdPizza.getName());
    }


    @ParameterizedTest
    @DisplayName("Test creazione pizza con topping")
    @Transactional
    @ValueSource(strings = {"pizza con topping 1, pizza con topping 2, pizza con topping 3"})
    public void createPizzaWithToppings(String pizzaName) {
        List<Topping> toppings = toppingService.findAll();
        Pizza newPizza = new Pizza();
        newPizza.setName(pizzaName);
        List<Topping> addedToppings = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int random = faker.number().numberBetween(0,toppings.size() -1);
            Topping t = toppings.get(random);
            newPizza.getToppings().add(t);
            t.getPizzas().add(newPizza);
            newPizza.setCalories(newPizza.getCalories() + t.getCalories());
            addedToppings.add(t);
            newPizza=pizzaService.save(newPizza);
        }

        Pizza createdPizza = pizzaService.findById(newPizza.getId());

        assertEquals(newPizza.getName(), createdPizza.getName());

        assertEquals(createdPizza.getToppings().size(), 5);

        for(int i = 0; i < addedToppings.size(); i++) {
            Topping t = addedToppings.get(i);
            boolean found = createdPizza.getToppings().contains(t);
            assertTrue(found);
        }
    }

}

