package epicode.it.pizzeria.entity.table;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {
    private final Faker faker;
    private final TableRepo tableRepo;

    public void createTable(int number) {
        Table table = new Table();
        table.setNumber(number);
        table.setMaxCustomers(faker.number().numberBetween(2,10));
        table.setStatus(faker.random().nextInt(1,10) < 6 ? TableStatus.OCCUPIED : TableStatus.FREE);
        tableRepo.save(table);
    }


}
