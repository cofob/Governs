package ru.firesquare.governs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import redempt.redlib.commandmanager.Messages;
import redempt.redlib.config.ConfigManager;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.SQLManager;

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

    @CommandHook("govern_set_description")
    public void governSetDescription(CommandSender sender, String govern_name, String value){
        new SQLManager().updateGovernDescription(govern_name, value);
    }

    @CommandHook("govern_set_approve")
    public void governSetApprove(CommandSender sender, String govern_name, boolean value){
        new SQLManager().updateGovernApprove(govern_name, value);
    }

    @CommandHook("govern_create")
    public void governCreate(CommandSender sender, String govern_name){
        new SQLManager().createGovern(govern_name);
    }

    @CommandHook("governs_get")
    public void getAllGoverns(CommandSender sender){
        sender.sendMessage(String.valueOf(new SQLManager().getAllGoverns()));
    }
}
