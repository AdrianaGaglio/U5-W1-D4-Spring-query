package epicode.it.pizzeria.entity.order;

import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import epicode.it.pizzeria.entity.table.Table;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@jakarta.persistence.Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String number = "#-";

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="customers_number")
    private int customersNumber;

    @Column(name="order_time")
    private LocalTime orderTime;

    @Column(name="total_price")
    private double totalPrice;

    @ManyToMany
    @ToString.Exclude
    private List<FoodAndDrink> orderedItems = new ArrayList<>();

    @ManyToOne
    private Table table;

    public double getTotalOrderedItems() {
        double total = 0;
        for (int i = 0; i < orderedItems.size(); i++) {
            FoodAndDrink item = orderedItems.get(i);
            total += item.getPrice();
        }
        return total;
    }
}