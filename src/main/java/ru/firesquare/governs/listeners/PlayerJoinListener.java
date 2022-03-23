package ru.firesquare.governs.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.milkbowl.vault.permission.Permission;
import ru.firesquare.governs.GovernsPlugin;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin (final PlayerJoinEvent event) {
        Permission perms = GovernsPlugin.getPermissions();
        final String message = ru.firesquare.governs.GovernsPlugin.getInstance().getConfig().getString("messages.from-listener");
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
