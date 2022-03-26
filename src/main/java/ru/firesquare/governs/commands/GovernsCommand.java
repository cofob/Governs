package ru.firesquare.governs.commands;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.Govern;
import ru.firesquare.governs.sql.GovernFeature;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

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
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_set_display_name")
    public void governSetDisplayName(CommandSender sender, String govern_name, String value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setDisplayName(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_set_display_name")
    public void governFeatSetDisplayName(CommandSender sender, String govern_name, String feature_name, String value){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            govern.setDisplayName(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_set_description")
    public void governFeatSetDescription(CommandSender sender, String govern_name, String feature_name, String value){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            govern.setDisplayName(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_set_icon")
    public void governFeatSetIcon(CommandSender sender, String govern_name, String feature_name, String value){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            govern.setIcon(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_set_x")
    public void governFeatSetX(CommandSender sender, String govern_name, String feature_name, int value){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            govern.setX(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_set_y")
    public void governFeatSetY(CommandSender sender, String govern_name, String feature_name, int value){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            govern.setY(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_set_icon")
    public void governSetIcon(CommandSender sender, String govern_name, String value){
        try {
            value = value.toUpperCase(Locale.ROOT);
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setIcon(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
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
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
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
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_remove")
    public void governRemove(CommandSender sender, String govern_name){
        try {
            GovernsPlugin.getInstance().getGovernDao().deleteById(govern_name);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_create")
    public void governFeatureCreate(CommandSender sender, String govern_name, String feature_name){
        try {
            GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
            return;
        }
        GovernFeature govern = new GovernFeature();
        govern.setGovern(govern_name);
        govern.setName(govern_name);
        govern.setDisplayName(govern_name);
        govern.setDescription("");
        govern.setIcon("STONE_AXE");
        govern.setX(1);
        govern.setY(1);
        try {
            GovernsPlugin.getInstance().getGovernFeatureDao().create(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_remove")
    public void governFeatureRemove(CommandSender sender, String govern_name, String feature_name){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            GovernsPlugin.getInstance().getGovernFeatureDao().delete(govern);
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_get_all")
    public void getAllGovernFeats(CommandSender sender, String govern_name){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            List<GovernFeature> govern_feats = GovernsPlugin.getInstance().getGovernFeatureDao().query(preparedQuery);
            sender.sendMessage(String.valueOf(govern_feats));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
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
