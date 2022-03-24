package ru.firesquare.governs.tasks;

import redempt.redlib.commandmanager.Messages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg("join_remember")));
    }
}