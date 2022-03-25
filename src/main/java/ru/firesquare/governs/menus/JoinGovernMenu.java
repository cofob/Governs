package ru.firesquare.governs.menus;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import ru.firesquare.governs.sql.SQLManager;
import xyz.janboerman.guilib.api.menu.*;

import java.util.List;

public class JoinGovernMenu {
    public static NotificationMenu build() {
        NotificationMenu menu = new NotificationMenu(9, "Example Gui 1", "join_quit");
        menu.setButton(8, new CloseButton<>());
        SQLManager manager = new SQLManager();
        List<String> governs = manager.getAllGoverns();
        int i = 0;
        governs.forEach(e -> {
            i += 1;
            menu.setButton(i, new MenuButton<NotificationMenu>() {
                @Override
                public void onClick(MenuHolder holder, InventoryClickEvent event) {
                    event.getWhoClicked().sendMessage(e);
                    MenuButton.super.onClick(holder, event);
                }
            });
        });
        return menu;
    }

    public static Inventory getInventory() {
        return build().getInventory();
    }
}
