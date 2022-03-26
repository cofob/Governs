package ru.firesquare.governs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import redempt.redlib.misc.EventListener;
import redempt.redlib.region.SpheroidRegion;
import redempt.redlib.region.events.RegionExitEvent;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Config;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.menus.JoinGovernMenu;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerLeaveSpawnListener implements Listener {
    public PlayerLeaveSpawnListener() {
        SpheroidRegion region = new SpheroidRegion(
                Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation(),
                Config.hermit_allowed_distance);
        region.enableEvents();
        new EventListener<>(GovernsPlugin.getInstance(), RegionExitEvent.class, e -> {
            try {
                if (GovernsPlugin.getInstance().getPlayerDao().queryForId(e.getPlayer().getName()).getGovern() == null) {
                    e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
                    JoinGovernMenu.INVENTORY.open(e.getPlayer());
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        new EventListener<>(GovernsPlugin.getInstance(), RegionExitEvent.class, e -> {
            try {
                if (GovernsPlugin.getInstance().getPlayerDao().queryForId(e.getPlayer().getName()).getGovern() == null) {
                    e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
                    e.getPlayer().sendTitle(ChatColor.translateAlternateColorCodes('&', Messages.join_govern_title),
                            ChatColor.translateAlternateColorCodes('&', Messages.join_govern_subtitle),
                            Messages.join_govern_fade_in, Messages.join_govern_stay, Messages.join_govern_fade_out);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }
}
