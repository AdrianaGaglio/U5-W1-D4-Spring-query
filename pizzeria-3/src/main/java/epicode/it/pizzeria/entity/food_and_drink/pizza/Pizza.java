package epicode.it.pizzeria.entity.food_and_drink.pizza;

import epicode.it.pizzeria.entity.menu.Menu;
import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name="pizzas")
public class Pizza extends FoodAndDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) && Objects.equals(toppings, pizza.toppings) && Objects.equals(menu, pizza.menu);
    }

    @ManyToMany(mappedBy = "pizzas", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Topping> toppings = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @ToString.Exclude
    private Menu menu;
}