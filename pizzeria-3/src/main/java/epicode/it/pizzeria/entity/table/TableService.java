package epicode.it.pizzeria.entity.table;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

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

    public int countTable() {
        return (int) tableRepo.count();
    }

    public Table save(Table newTable) {
        tableRepo.save(newTable);
        return newTable;
    }

    public Table findById(long id) {
        return tableRepo.findById(id).orElse(null);
    }

    public List<Table> findAll() {
        return tableRepo.findAll();
    }

    public List<Table> findOrderByMaxCustomersAsc() {
        return tableRepo.findOrderByMaxCustomersAsc();
    }

}
