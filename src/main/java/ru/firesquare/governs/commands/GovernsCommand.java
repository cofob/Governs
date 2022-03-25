package ru.firesquare.governs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.Govern;

import java.sql.SQLException;

public class GovernsCommand {
    @CommandHook("join")
    public void joinGovern(CommandSender sender) {
        Player player = sender.getServer().getPlayer(sender.getName());
        assert player != null;
        JoinGovernMenu.INVENTORY.open(player);
    }

    @CommandHook("reload")
    public void reloadConfig(CommandSender sender) {
        GovernsPlugin.getInstance().reloadFileConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.reload));
    }

    @CommandHook("govern_set_description")
    public void governSetDescription(CommandSender sender, String govern_name, String value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setDescription(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @CommandHook("govern_set_approve")
    public void governSetApprove(CommandSender sender, String govern_name, boolean value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setApprove(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @CommandHook("govern_create")
    public void governCreate(CommandSender sender, String govern_name){
        Govern govern = new Govern();
        govern.setName(govern_name);
        govern.setDescription("");
        govern.setApprove(false);
        govern.setIcon("STONE_AXE");
        govern.setDisplayName(govern_name);
        try {
            GovernsPlugin.getInstance().getGovernDao().create(govern);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
    }

    @CommandHook("governs_get_all")
    public void getAllGoverns(CommandSender sender){
        try {
            sender.sendMessage(String.valueOf(GovernsPlugin.getInstance().getGovernDao().queryForAll()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @CommandHook("govern_get")
    public void getGovern(CommandSender sender, String govern_name){
        try {
            sender.sendMessage(GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name).getName());
        } catch (Exception e) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                                e.getMessage().replace('\n', ' '));
        }
    }
}
