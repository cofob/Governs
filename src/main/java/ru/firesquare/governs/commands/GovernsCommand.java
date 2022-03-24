package ru.firesquare.governs.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import redempt.redlib.commandmanager.Messages;
import redempt.redlib.config.ConfigManager;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.SelectGovernMenu;

public class GovernsCommand {
    @CommandHook("openinv")
    public void openInv(CommandSender sender) {
        final String message = ru.firesquare.governs.GovernsPlugin.getInstance().getConfig().getString("messages.from-command");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        Player player = Bukkit.getServer().getPlayer(sender.getName());
        player.openInventory(SelectGovernMenu.getInventory());
    }

    @CommandHook("reload")
    public void reloadConfig(CommandSender sender) {
        ConfigManager.create(GovernsPlugin.getInstance()).reload();
        GovernsPlugin.getInstance().reloadFileConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg("reload")));
    }
}
