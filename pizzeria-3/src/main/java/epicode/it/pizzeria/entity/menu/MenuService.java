package epicode.it.pizzeria.entity.menu;

import epicode.it.pizzeria.entity.food_and_drink.drink.Drink;
import epicode.it.pizzeria.entity.food_and_drink.drink.DrinkRepo;
import epicode.it.pizzeria.entity.food_and_drink.pizza.Pizza;
import epicode.it.pizzeria.entity.food_and_drink.pizza.PizzaRepo;
import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    public final MenuRepo menuRepo;
    public final PizzaRepo pizzaRepo;
    public final ToppingRepo toppingRepo;
    public final DrinkRepo drinkRepo;

    public Menu createMenu(String menuName) {
        Menu menu = new Menu();
        List<Pizza> pizzas = pizzaRepo.findAll();
        List<Topping> toppings = toppingRepo.findAll();
        List<Drink> drinks = drinkRepo.findAll();
        menu.setName(menuName);
        for (int i = 0; i < pizzas.size(); i++) {
            menu.getPizzas().add(pizzas.get(i));
            pizzas.get(i).setMenu(menu);
        }
        for (int i = 0; i < toppings.size(); i++) {
            menu.getToppings().add(toppings.get(i));
            toppings.get(i).setMenu(menu);
        }
        for (int i = 0; i < drinks.size(); i++) {
            menu.getDrinks().add(drinks.get(i));
            drinks.get(i).setMenu(menu);
        }
        menuRepo.save(menu);
        return menu;
    }

    public int countMenu() {
        return (int) menuRepo.count();
    }

    public Menu findById(long id) {
        return menuRepo.findById(id).orElse(null);
    }
}
