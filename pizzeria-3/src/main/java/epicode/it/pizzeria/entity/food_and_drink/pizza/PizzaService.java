package epicode.it.pizzeria.entity.food_and_drink.pizza;

import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingRepo;
import epicode.it.pizzeria.utilities.Utilities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepo pizzaRepo;
    private final ObjectProvider<Pizza> pizzaProvider;
    private final ToppingRepo toppingRepo;

    public void createStandardPizzas() {

        if (pizzaRepo.count() == 0) {
            // pizza margherita
            Pizza margherita = pizzaProvider.getObject();
            pizzaRepo.save(margherita);

            // hawaiianPizza
            Pizza hawaiianPizza = pizzaProvider.getObject();
            hawaiianPizza.setName("Hawaiian Pizza");
            hawaiianPizza.setPrice(6.49);
            Topping ham = toppingRepo.findByName("ham");
            hawaiianPizza.getToppings().add(ham);
            Topping pineapple = toppingRepo.findByName("pineapple");
            hawaiianPizza.getToppings().add(pineapple);
            ham.getPizzas().add(hawaiianPizza);
            pineapple.getPizzas().add(hawaiianPizza);
            hawaiianPizza.setCalories(hawaiianPizza.getCalories() + ham.getCalories() + pineapple.getCalories());
            pizzaRepo.save(hawaiianPizza);


            // pizza salame
            Pizza salamiPizza = pizzaProvider.getObject();
            salamiPizza.setName("Salami Pizza");
            salamiPizza.setPrice(5.99);
            Topping salami = toppingRepo.findByName("salami");
            salamiPizza.getToppings().add(salami);
            salami.getPizzas().add(salamiPizza);
            salamiPizza.setCalories(salamiPizza.getCalories() + salami.getCalories());
            pizzaRepo.save(salamiPizza);

            // pizza tonno e cipolle
            Pizza onionsTunaPizza = pizzaProvider.getObject();
            onionsTunaPizza.setName("Onions & Tuna Pizza");
            onionsTunaPizza.setPrice(8.99);
            Topping tuna = toppingRepo.findByName("tuna");
            Topping onions = toppingRepo.findByName("onions");
            onionsTunaPizza.getToppings().add(tuna);
            onionsTunaPizza.getToppings().add(onions);
            tuna.getPizzas().add(onionsTunaPizza);
            onions.getPizzas().add(onionsTunaPizza);
            onionsTunaPizza.setCalories(onionsTunaPizza.getCalories() + tuna.getCalories() + onions.getCalories());
        }

    }

    public Pizza createCustomPizza(List<Topping> toppings) {
        Pizza newPizza = pizzaProvider.getObject();
        String pizzaName = "";
        for (int i = 0; i < toppings.size(); i++) {
            Topping t = toppings.get(i);
            Topping topping = toppingRepo.findByName(t.getName());
            newPizza.getToppings().add(topping);
            topping.getPizzas().add(newPizza);
            newPizza.setCalories(newPizza.getCalories() + topping.getCalories());
            pizzaName += Utilities.capitalizeFirstLetter(t.getName());
            if (i < toppings.size()) pizzaName += " ";
        }
        ;
        newPizza.setName(pizzaName);
        pizzaRepo.save(newPizza);
        return newPizza;
    }

    public Pizza save(Pizza newPizza) {
        pizzaRepo.save(newPizza);
        return newPizza;
    }

    public int countPizza() {
        return (int) pizzaRepo.count();
    }

    public Pizza findById(long id){
        return pizzaRepo.findById(id).orElse(null);
    }
}
