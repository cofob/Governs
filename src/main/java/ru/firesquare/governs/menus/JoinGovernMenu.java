package ru.firesquare.governs.menus;

import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.HumanEntity;

public class JoinGovernMenu {
    private Gui gui;

    public JoinGovernMenu() {
        gui = Gui.gui()
                .title(Component.text("Title"))
                .rows(6)
                .create();
    }

    public void open(HumanEntity player) {
        gui.open(player);
    }
}
