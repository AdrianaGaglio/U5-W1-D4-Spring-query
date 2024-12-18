package epicode.it.pizzeria.entity.food_and_drink.topping;

import epicode.it.pizzeria.entity.menu.Menu;
import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import epicode.it.pizzeria.entity.food_and_drink.pizza.Pizza;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name="toppings")
public class Topping extends FoodAndDrink {

    @ManyToMany(cascade = {CascadeType.ALL})
    @ToString.Exclude
    private List<Pizza> pizzas = new ArrayList<>();

    @ManyToOne
    private Menu menu;

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + getId() +
                ", name=" + getName() +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Topping topping = (Topping) o;
        return Objects.equals(topping.getId(), this.getId()) && Objects.equals(topping.getName(), this.getName());
    }

}