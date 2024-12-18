package epicode.it.pizzeria.entity.food_and_drink.topping;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepo extends JpaRepository<Topping, Long> {

    public Topping findByName(String name);

}
