package epicode.it.pizzeria.menu;

import epicode.it.pizzeria.entity.menu.Menu;
import epicode.it.pizzeria.entity.menu.MenuService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestMenu {
    @Autowired
    private MenuService menuService;


    @Test
    @Transactional
    @DisplayName("Test creazione menu")
    public void testCreateMenu() {
        int existingMenu = menuService.countMenu();
        Menu newMenu = menuService.createMenu("menu di test");

        Menu createdMenu = menuService.findById(newMenu.getId());

        int updatedMenu = menuService.countMenu();

        assertEquals(newMenu.getId(), createdMenu.getId());

        assertEquals(newMenu.getName(), createdMenu.getName());

        assertEquals(existingMenu+1, updatedMenu);
    }
}
