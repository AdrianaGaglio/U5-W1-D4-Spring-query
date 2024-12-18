package epicode.it.pizzeria.order;

import com.github.javafaker.Faker;
import epicode.it.pizzeria.entity.order.Order;
import epicode.it.pizzeria.entity.order.OrderService;
import epicode.it.pizzeria.entity.order.Status;
import epicode.it.pizzeria.entity.table.Table;
import epicode.it.pizzeria.entity.table.TableService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TestOrder {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TableService tableService;

    @Autowired
    private Faker faker;

    @Test
    @DisplayName("Test creazione ordine con tavolo")
    public void testCreateOrder() {
        List<Table> tables = tableService.findAll();
        int existingOrders = orderService.countOrders();
        Order newOrder = new Order();
        int random = faker.number().numberBetween(0,tables.size()-1);
        Table foundTable = tables.get(random);
        newOrder.setTable(foundTable);
        newOrder=orderService.save(newOrder);

        int updatedOrders = orderService.countOrders();

        assertEquals(existingOrders+1,updatedOrders);

        Order createdOrder = orderService.findById(newOrder.getId());

        assertEquals(newOrder.getId(),createdOrder.getId());

        assertEquals(foundTable, createdOrder.getTable());

    }

    @ParameterizedTest
    @DisplayName("Test modifica ordine")
    @ValueSource(strings = {"IN_PREPARATION", "DELIVERED"})
    public void testUpdateOrder(String status) {
        List<Order> orders = orderService.findByStatus(Status.valueOf("CREATED"));
        Order foundOrder = orders.get(faker.number().numberBetween(0,orders.size()-1));
        Order updatedOrder = orderService.updateOrder(foundOrder, Status.valueOf(status));

        Order updatedOrderFromDB = orderService.findById(foundOrder.getId());

        assertNotEquals(foundOrder.getStatus(), updatedOrderFromDB.getStatus());

    }
}
