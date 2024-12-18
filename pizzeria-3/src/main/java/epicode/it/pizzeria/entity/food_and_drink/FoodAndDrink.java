package epicode.it.pizzeria.entity.food_and_drink;

import epicode.it.pizzeria.entity.food_and_drink.drink.Alcohol;
import epicode.it.pizzeria.entity.food_and_drink.drink.Drink;
import epicode.it.pizzeria.entity.food_and_drink.drink.DrinkRepo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract public class FoodAndDrink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int calories;
    private double price;


}