package epicode.it.pizzeria.entity.food_and_drink.drink;

import epicode.it.pizzeria.entity.menu.Menu;
import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="drinks")
public class Drink extends FoodAndDrink {
    private double quantity;

    @ManyToOne
    private Menu menu;
}