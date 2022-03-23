package ru.firesquare.governs.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.inventory.Inventory;
import redempt.redlib.inventorygui.InventoryGUI;
import redempt.redlib.inventorygui.ItemButton;
import redempt.redlib.itemutils.ItemBuilder;

public class ExampleMenu {
    private InventoryGUI buildGui() {
        InventoryGUI gui = new InventoryGUI(Bukkit.createInventory(null, 27, "Name"));

        ItemButton button = ItemButton.create(new ItemBuilder(Material.EMERALD_BLOCK)
                .setName("Click me!"), e -> {
                    Bukkit.getLogger().info(String.valueOf(e));
                });
        gui.addButton(button, 13);

        return gui;
    }

    public InventoryGUI getInstance() {
        return buildGui();
    }

    public Inventory getInventory() {
        return buildGui().getInventory();
    }
}
