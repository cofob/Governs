package ru.firesquare.governs.menus;

import org.bukkit.inventory.Inventory;
import xyz.janboerman.guilib.api.menu.CloseButton;

public class JoinGovernMenu {
    public static NotificationMenu build() {
        NotificationMenu menu = new NotificationMenu(9, "Example Gui 1", "join_quit");
        menu.setButton(8, new CloseButton<>());
        return menu;
    }

    public static Inventory getInventory() {
        return build().getInventory();
    }
}
