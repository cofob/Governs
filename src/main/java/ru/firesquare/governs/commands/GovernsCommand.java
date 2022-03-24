package ru.firesquare.governs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import redempt.redlib.commandmanager.Messages;
import redempt.redlib.config.ConfigManager;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;

public class GovernsCommand {
    @CommandHook("join")
    public void joinGovern(CommandSender sender) {
        Player player = sender.getServer().getPlayer(sender.getName());
        assert player != null;
        player.openInventory(JoinGovernMenu.getInventory());
    }

    @CommandHook("reload")
    public void reloadConfig(CommandSender sender) {
        ConfigManager.create(GovernsPlugin.getInstance()).reload();
        GovernsPlugin.getInstance().reloadFileConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg("reload")));
    }
}
