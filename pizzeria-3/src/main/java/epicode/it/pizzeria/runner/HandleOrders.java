package epicode.it.pizzeria.runner;

import com.github.javafaker.Faker;
import epicode.it.pizzeria.entity.order.OrderService;
import epicode.it.pizzeria.entity.order.Status;
import epicode.it.pizzeria.entity.order.OrderRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(8)
@RequiredArgsConstructor
public class HandleOrders implements ApplicationRunner {
    private final OrderService orderService;
    private final Faker faker;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        List<epicode.it.pizzeria.entity.order.Order> createdOrder = orderService.findByStatus(Status.CREATED);

        System.out.println();
        System.out.println("=> list of created order:");
        createdOrder.forEach(System.out::println);

        for (int i = 0; i < 3; i++) {
            int random = faker.number().numberBetween(0, createdOrder.size() - 1);
            epicode.it.pizzeria.entity.order.Order order = createdOrder.get(random);
            orderService.updateOrder(order, Status.IN_PREPARATION);
        }
        System.out.println();
        System.out.println("=> list of in preparation order:");
        orderService.findByStatus(Status.IN_PREPARATION).forEach(System.out::println);

        List<epicode.it.pizzeria.entity.order.Order> inPreparationOrder = orderService.findByStatus(Status.IN_PREPARATION);

        int random = faker.number().numberBetween(0, inPreparationOrder.size() - 1);
        epicode.it.pizzeria.entity.order.Order order = inPreparationOrder.get(random);
        orderService.updateOrder(order, Status.DELIVERED);
        System.out.println();
        System.out.println("=> list of delivered order:");
        orderService.findByStatus(Status.DELIVERED).forEach(System.out::println);

     }
}
