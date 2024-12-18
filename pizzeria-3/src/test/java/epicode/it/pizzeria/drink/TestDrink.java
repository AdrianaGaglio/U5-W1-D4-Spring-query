package epicode.it.pizzeria.drink;

import epicode.it.pizzeria.entity.food_and_drink.drink.Drink;
import epicode.it.pizzeria.entity.food_and_drink.drink.DrinkService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestDrink {
    @Autowired
    private DrinkService drinkService;

    @Test
    @DisplayName("Test creazione drink")
    public void testCreateDrink() {
        int existingDrinks = drinkService.countDrink();
        Drink newDrink = new Drink();
        newDrink.setName("drink di test");
        newDrink=drinkService.save(newDrink);

        int updatedDrinks = drinkService.countDrink();

        assertEquals(existingDrinks +1, updatedDrinks);

        Drink createdDrink = drinkService.findById(newDrink.getId());

        assertEquals(newDrink.getName(), createdDrink.getName());

    }

}
