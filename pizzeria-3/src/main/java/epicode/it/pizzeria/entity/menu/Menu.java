package epicode.it.pizzeria.entity.menu;

import epicode.it.pizzeria.entity.food_and_drink.drink.Drink;
import epicode.it.pizzeria.entity.food_and_drink.pizza.Pizza;
import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pizza> pizzas = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topping> toppings = new ArrayList<>();

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Drink> drinks = new ArrayList<>();

}