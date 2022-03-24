package ru.firesquare.governs.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import redempt.redlib.misc.EventListener;
import redempt.redlib.region.SpheroidRegion;
import redempt.redlib.region.events.RegionExitEvent;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Config;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.SQLManager;

import java.util.Objects;

public class PlayerLeaveSpawnListener implements Listener {
    public PlayerLeaveSpawnListener() {
        SpheroidRegion region = new SpheroidRegion(
                Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation(),
                Config.hermit_allowed_distance);
        region.enableEvents();
        SQLManager manager = new SQLManager();
        new EventListener<>(GovernsPlugin.getInstance(), RegionExitEvent.class, e -> {
            if (manager.checkPlayerInSomeGovern(e.getPlayer().getName())) {
                e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
                e.getPlayer().openInventory(JoinGovernMenu.getInventory());
            }
        });
        new EventListener<>(GovernsPlugin.getInstance(), RegionExitEvent.class, e -> {
            if (!manager.checkPlayerInSomeGovern(e.getPlayer().getName())) {
                e.getPlayer().teleport(Objects.requireNonNull(Bukkit.getWorld("world")).getSpawnLocation());
                e.getPlayer().openInventory(JoinGovernMenu.getInventory());
            }
        });
    }
}
