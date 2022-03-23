package ru.firesquare.governs.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        final String message = ru.firesquare.governs.GovernsPlugin.getInstance().getConfig().getString("messages.from-task");
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}