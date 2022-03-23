package ru.firesquare.governs.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import redempt.redlib.inventorygui.InventoryGUI;
import redempt.redlib.inventorygui.ItemButton;
import redempt.redlib.itemutils.ItemBuilder;


public class BaseMenu {
    private InventoryGUI buildGui() {
        InventoryGUI gui = new InventoryGUI(Bukkit.createInventory(null, 27, "Name"));
        return gui;
    }
}
