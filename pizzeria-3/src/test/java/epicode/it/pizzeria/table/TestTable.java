package epicode.it.pizzeria.table;

import epicode.it.pizzeria.entity.table.Table;
import epicode.it.pizzeria.entity.table.TableService;
import epicode.it.pizzeria.entity.table.TableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestTable {

    @Autowired
    private TableService tableService;

    @Test
    @DisplayName("Test creazione tavolo")
    public void testCreateTable() {
        int existingTables = tableService.countTable();
        Table newTable = new Table();
        newTable.setStatus(TableStatus.FREE);
        newTable=tableService.save(newTable);

        int updatedTables = tableService.countTable();

        assertEquals(existingTables+1,updatedTables);

        Table createdTable = tableService.findById(newTable.getId());

        assertEquals(newTable.getId(),createdTable.getId());

        assertEquals(newTable.getStatus(),createdTable.getStatus());
    }
}
