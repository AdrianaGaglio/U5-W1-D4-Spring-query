package epicode.it.pizzeria.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChargeConfiguration {

    @Bean(name="charge")
    public Double getCharge(){
        return 1.5;
    }
}
