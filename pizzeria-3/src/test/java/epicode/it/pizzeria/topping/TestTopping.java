package epicode.it.pizzeria.topping;

import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestTopping {
    @Autowired
    private ToppingService toppingService;

    @Test
    @DisplayName("Test creazione topping")
    public void testCreateTopping() {
        int toppingEsistenti = toppingService.countTopping();
        Topping newTopping = new Topping();
        newTopping.setName("topping di test");
        newTopping=toppingService.save(newTopping);
        int toppingAggiornati = toppingService.countTopping();
        assertEquals(toppingEsistenti + 1, toppingAggiornati);
        Topping createdTopping = toppingService.findById(newTopping.getId());
        assertEquals(newTopping.getName(),createdTopping.getName());
    }
}
