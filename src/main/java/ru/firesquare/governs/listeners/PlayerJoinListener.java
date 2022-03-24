package ru.firesquare.governs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.SQLManager;

import java.util.Objects;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        SQLManager manager = new SQLManager();
        e.getPlayer().sendMessage(String.valueOf(manager.checkPlayerInSomeGovern(e.getPlayer().getName())));
        if (!manager.checkPlayerInSomeGovern(e.getPlayer().getName())) {
            e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
            e.getPlayer().openInventory(JoinGovernMenu.getInventory());
        }
    }
}
