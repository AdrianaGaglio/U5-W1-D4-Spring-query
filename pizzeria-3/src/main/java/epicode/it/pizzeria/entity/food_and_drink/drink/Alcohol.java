package epicode.it.pizzeria.entity.food_and_drink.drink;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(name="findAll_Alcohol", query="SELECT a FROM Alcohol a")
public class Alcohol extends Drink {
    private double volume;
}