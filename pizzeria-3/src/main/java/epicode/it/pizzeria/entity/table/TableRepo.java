package epicode.it.pizzeria.entity.table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableRepo extends JpaRepository<Table, Long> {

    @Query("SELECT t FROM Table t ORDER BY t.maxCustomers ASC")
    public List<Table> findOrderByMaxCustomersAsc();
}
