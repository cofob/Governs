package ru.firesquare.governs.menus;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.janboerman.guilib.api.menu.CloseButton;
import xyz.janboerman.guilib.api.menu.MenuButton;

public class SelectGovernMenu {
    public static NotificationMenu build() {
        NotificationMenu menu = new NotificationMenu(9, "Example Gui 1", "select_quit");
        menu.setButton(8, new CloseButton<>());
        return menu;
    }

    public static Inventory getInventory() {
        return build().getInventory();
    }
}
