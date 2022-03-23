package ru.firesquare.governs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import ru.firesquare.governs.menus.ExampleMenu;

import redempt.redlib.commandmanager.CommandHook;

public class GovernsCommand {
    @CommandHook("openinv")
    public void openInv(CommandSender sender) {
        final String message = ru.firesquare.governs.GovernsPlugin.getInstance().getConfig().getString("messages.from-command");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        Player player = Bukkit.getServer().getPlayer(sender.getName());
        player.openInventory(new ExampleMenu().getInventory());
    }
}
