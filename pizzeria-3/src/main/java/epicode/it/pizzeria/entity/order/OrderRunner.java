package epicode.it.pizzeria.entity.order;

import com.github.javafaker.Faker;
import epicode.it.pizzeria.entity.menu.Menu;
import epicode.it.pizzeria.entity.food_and_drink.drink.Drink;
import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import epicode.it.pizzeria.entity.food_and_drink.pizza.Pizza;
import epicode.it.pizzeria.entity.food_and_drink.topping.Topping;
import epicode.it.pizzeria.entity.food_and_drink.topping.ToppingRepo;
import epicode.it.pizzeria.entity.menu.MenuRepo;
import epicode.it.pizzeria.entity.table.Table;
import epicode.it.pizzeria.entity.table.TableRepo;
import epicode.it.pizzeria.entity.table.TableStatus;
import epicode.it.pizzeria.entity.food_and_drink.pizza.PizzaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@org.springframework.core.annotation.Order(7)
public class OrderRunner implements ApplicationRunner {
    private final OrderService orderService;
    private final PizzaService pizzaService;
    private final MenuRepo menuRepo;
    private final TableRepo tableRepo;
    private final ToppingRepo toppingRepo;
    private final Faker faker;
    private final OrderRepo orderRepo;

    @Override
    @Transactional
    @org.springframework.core.annotation.Order(6)
    public void run(ApplicationArguments args) throws Exception {

        Menu menu = menuRepo.getReferenceById(1L);

        List<Table> tables = tableRepo.findAll();

        for (int i = 0; i < tables.size(); i++) {
            Table table = tables.get(i);
            if (table.getStatus() != TableStatus.FREE) {
                List<FoodAndDrink> orderedItems = new ArrayList<>();
                int seats = faker.number().numberBetween(1, table.getMaxCustomers());
                for (int j = 0; j < seats; j++) {
                    List<Drink> drinks = menu.getDrinks();
                    int randomChoise = faker.random().nextInt(1, 2);
                    if (randomChoise == 1) {
                        List<Pizza> pizzas = menu.getPizzas();
                        orderedItems.add(drinks.get(faker.number().numberBetween(0, drinks.size() - 1)));
                        orderedItems.add(pizzas.get(faker.number().numberBetween(0, pizzas.size() - 1)));
                    } else {
                        List<Topping> additional = new ArrayList<>();
                        for (int k = 0; k < 3; k++) {
                            Topping topping = menu.getToppings().get(faker.number().numberBetween(0, menu.getToppings().size() - 1));
                            additional.add(topping);
                        }
                        pizzaService.createCustomPizza(additional);
                    }
                }
                Order order = orderService.createOrder(table, orderedItems);
            }
        }

        List<Order> orders = orderRepo.findAll();

        System.out.println();
        System.out.println("Orders");
        System.out.printf("%-15s %15s %15s %15s%n", "Order", "Total price", "Status", "Seats");
        orders.forEach(o -> {
            System.out.printf("%-15s %15s %15s %15s%n", o.getNumber(), "€ " + String.format("%.2f", o.getTotalPrice()), o.getStatus().toString(), o.getCustomersNumber());
        });
        System.out.println();
    }
}
