package epicode.it.pizzeria.entity.food_and_drink.topping;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {
    @Autowired
    @Qualifier("cheese")
    private Topping cheese;

    @Autowired
    @Qualifier("tomato")
    private Topping tomato;

    @Autowired
    @Qualifier("ham")
    private Topping ham;

    @Autowired
    @Qualifier("pineapple")
    private Topping pineapple;

    @Autowired
    @Qualifier("salami")
    private Topping salami;

    @Autowired
    @Qualifier("onions")
    private Topping onions;

    @Autowired
    @Qualifier("tuna")
    private Topping tuna;

    @Autowired
    private ToppingRepo toppingRepo;

    public void saveAll(){
        toppingRepo.save(cheese);
        toppingRepo.save(tomato);
        toppingRepo.save(ham);
        toppingRepo.save(pineapple);
        toppingRepo.save(salami);
        toppingRepo.save(onions);
        toppingRepo.save(tuna);
    }

    public Topping save(Topping newTopping) {
        toppingRepo.save(newTopping);
        return newTopping;
    }

    public int countTopping() {
        return (int) toppingRepo.count();
    }

    public Topping findById(long id) {
        return toppingRepo.findById(id).orElse(null);
    }

    public List<Topping> findAll() {
        return toppingRepo.findAll();
    }
}
