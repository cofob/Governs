package ru.firesquare.governs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import ru.firesquare.governs.menus.ExampleMenu;

public class ExampleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final String message = ru.firesquare.governs.GovernsPlugin.getInstance().getConfig().getString("messages.from-command");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        Player player = Bukkit.getServer().getPlayer(sender.getName());
        player.openInventory(new ExampleMenu().getInventory());
        return true;
    }
}
