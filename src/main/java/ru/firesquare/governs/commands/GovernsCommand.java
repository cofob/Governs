package ru.firesquare.governs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.Command;
import redempt.redlib.commandmanager.Messages;
import ru.firesquare.governs.GovernsPlugin;
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

    @CommandHook("reload")
    public void reloadConfig(CommandSender sender) {
        GovernsPlugin.getFileConfig().reload();
        GovernsPlugin.getInstance().reloadFileConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg("reload")));
    }
}
