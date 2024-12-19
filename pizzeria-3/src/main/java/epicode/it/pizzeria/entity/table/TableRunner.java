package epicode.it.pizzeria.entity.table;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(5)
public class TableRunner implements ApplicationRunner {
    private final TableService tableService;
    private final TableRepo tableRepo;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {



        for (int i = 0; i < 20; i++) {
            tableService.createTable(i+1);
        }

        List<Table> tables = tableRepo.findOrderByMaxCustomersAsc();
        System.out.println();
        System.out.println("Tables list:");
        tables.forEach(t -> {
            System.out.println("Table number: " + t.getNumber() + " - Table status: " + t.getStatus().toString() + " - Maximum seats: " + t.getMaxCustomers());
        });
        System.out.println();
    }
}
