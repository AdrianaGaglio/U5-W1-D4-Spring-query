package epicode.it.pizzeria.entity.food_and_drink.drink;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
    @Autowired
    @Qualifier("lemonade")
    private Drink lemonade;

    @Autowired
    @Qualifier("coca")
    private Drink coca;

    @Autowired
    @Qualifier("fanta")
    private Drink fanta;

    @Autowired
    @Qualifier("water")
    private Drink water;

    @Autowired
    @Qualifier("wine")
    private Alcohol wine;

    @Autowired
    @Qualifier("beer")
    private Alcohol beer;

    @Autowired
    private DrinkRepo drinkRepo;

    public void createAllDrinks() {
            drinkRepo.save(lemonade);
            drinkRepo.save(coca);
            drinkRepo.save(fanta);
            drinkRepo.save(water);
            drinkRepo.save(wine);
            drinkRepo.save(beer);
    }

    public Drink save(Drink newDrink) {
        drinkRepo.save(newDrink);
        return newDrink;
    }

    public Drink findById(long id){
        return drinkRepo.findById(id).orElse(null);
    }

    public int countDrink() {
        return (int) drinkRepo.count();
    }
}
