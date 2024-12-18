package epicode.it.pizzeria.entity.table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@jakarta.persistence.Table(name="tables")
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int number;

    @Enumerated(EnumType.STRING)
    private TableStatus status;

    @Column(name="max_customers")
    private int maxCustomers;

}