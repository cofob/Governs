package ru.firesquare.governs.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import ru.firesquare.governs.config.Messages;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Messages.join_remember));
    }
}