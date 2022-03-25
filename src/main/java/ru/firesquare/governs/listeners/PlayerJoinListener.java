package ru.firesquare.governs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.Player;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        Player player = new Player();
        player.setName(e.getPlayer().getName());
        try {
            GovernsPlugin.getInstance().getPlayerDao().createIfNotExists(player);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (player.getGovern() == null) {
            e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
            JoinGovernMenu.INVENTORY.open(e.getPlayer());
        }
    }
}
