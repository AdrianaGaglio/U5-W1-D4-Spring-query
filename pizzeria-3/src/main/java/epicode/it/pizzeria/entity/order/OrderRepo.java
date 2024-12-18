package epicode.it.pizzeria.entity.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {

    public List<Order> findByStatus(Status status);
}
