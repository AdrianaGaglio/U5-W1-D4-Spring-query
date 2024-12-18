package epicode.it.pizzeria.entity.food_and_drink.drink;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DrinkConfigurator {

    @Bean(name = "lemonade")
    public Drink getLemonade() {
        Drink lemonade = new Drink();
        lemonade.setName("lemonade");
        lemonade.setPrice(1.29);
        lemonade.setCalories(128);
        lemonade.setQuantity(0.33);
        return lemonade;
    }

    @Bean(name="coca")
    public Drink getCoca() {
        Drink coca = new Drink();
        coca.setName("coca-cola");
        coca.setPrice(1.29);
        coca.setCalories(138);
        coca.setQuantity(0.33);
        return coca;
    }

    @Bean(name="fanta")
    public Drink getFanta() {
        Drink fanta = new Drink();
        fanta.setName("fanta");
        fanta.setCalories(138);
        fanta.setPrice(1.29);
        fanta.setQuantity(0.33);
        return fanta;
    }

    @Bean(name="water")
    public Drink getWater() {
        Drink water = new Drink();
        water.setName("water");
        water.setPrice(1.29);
        water.setCalories(0);
        water.setQuantity(0.5);
        return water;
    }

    @Bean(name="wine")
    public Alcohol getWine() {
        Alcohol wine = new Alcohol();
        wine.setName("wine");
        wine.setPrice(7.49);
        wine.setCalories(607);
        wine.setQuantity(0.75);
        wine.setVolume(13);
        return wine;
    }

    @Bean(name="beer")
    public Alcohol getBeer() {
        Alcohol beer = new Alcohol();
        beer.setName("beer");
        beer.setPrice(4.50);
        beer.setCalories(200);
        beer.setQuantity(0.5);
        beer.setVolume(5.5);
        return beer;
    }


}
