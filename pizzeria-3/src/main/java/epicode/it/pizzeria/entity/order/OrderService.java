package epicode.it.pizzeria.entity.order;

import com.github.javafaker.Faker;
import epicode.it.pizzeria.entity.food_and_drink.FoodAndDrink;
import epicode.it.pizzeria.entity.table.Table;
import epicode.it.pizzeria.entity.table.TableRepo;
import epicode.it.pizzeria.entity.table.TableStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;
    private final TableRepo tableRepo;
    private final Faker faker;

    @Value("${application.cover_charge}")
    private double charge;

    public Order createOrder(Table table, List<FoodAndDrink> orderedItems) {
        Order order = new Order();
        order.setTable(table);
        order.setCustomersNumber(faker.number().numberBetween(1, table.getMaxCustomers()));
        double chargeSum = charge * order.getCustomersNumber();
        order.setOrderTime(LocalTime.now());
        order.setStatus(Status.CREATED);
        long orderNumber = orderRepo.count() + 1;
        order.setNumber(order.getNumber() + orderNumber);
        orderedItems.forEach(item -> order.getOrderedItems().add(item));
        order.setTotalPrice(order.getTotalOrderedItems() + chargeSum);
        orderRepo.save(order);
        return order;
    }

    public Order save(Order newOrder) {
        orderRepo.save(newOrder);
        return newOrder;
    }

    public int countOrders() {
        return (int) orderRepo.count();
    }

    public Order findById(long id) {
        return orderRepo.findById(id).orElse(null);
    }

    public Order updateOrder(Order order, Status newStatus) {
        order.setStatus(newStatus);
        orderRepo.save(order);
        return order;
    }

    public List<Order> findByStatus(Status status) {
        return orderRepo.findByStatus(status);
    }

}
