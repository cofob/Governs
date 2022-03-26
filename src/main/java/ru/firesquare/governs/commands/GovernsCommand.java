package ru.firesquare.governs.commands;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import redempt.redlib.commandmanager.CommandHook;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.menus.JoinGovernMenu;
import ru.firesquare.governs.sql.Govern;
import ru.firesquare.governs.sql.GovernFeature;
import ru.firesquare.governs.utils.ChatUtils;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class GovernsCommand {
    @CommandHook("join")
    public void joinGovern(CommandSender sender) {
        Player player = sender.getServer().getPlayer(sender.getName());
        assert player != null;
        try {
            if (GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName()).getGovern() != null) {
                player.sendMessage(ChatUtils.translate(Messages.already_in_govern));
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JoinGovernMenu.INVENTORY.open(player);
    }

    @CommandHook("reload")
    public void reloadConfig(CommandSender sender) {
        GovernsPlugin.getInstance().reloadFileConfig();
        sender.sendMessage(ChatUtils.translate(Messages.reload));
    }

    @CommandHook("govern_set_description")
    public void governSetDescription(CommandSender sender, String govern_name, String value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setDescription(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_set_display_name")
    public void governSetDisplayName(CommandSender sender, String govern_name, String value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setDisplayName(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            govern.setDescription(value);
            GovernsPlugin.getInstance().getGovernFeatureDao().update(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_set_approve")
    public void governSetApprove(CommandSender sender, String govern_name, boolean value){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setApprove(value);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_set_base")
    public void governSetBase(CommandSender sender, String govern_name, int x, int y, int z){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            govern.setBaseX(x);
            govern.setBaseY(y);
            govern.setBaseZ(z);
            GovernsPlugin.getInstance().getGovernDao().update(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
        govern.setBaseX(0);
        govern.setBaseY(80);
        govern.setBaseZ(0);
        try {
            GovernsPlugin.getInstance().getGovernDao().create(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_remove")
    public void governRemove(CommandSender sender, String govern_name){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            List<GovernFeature> feats = GovernsPlugin.getInstance().getGovernFeatureDao().query(preparedQuery);
            GovernsPlugin.getInstance().getGovernDao().deleteById(govern_name);
            GovernsPlugin.getInstance().getGovernFeatureDao().delete(feats);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_create")
    public void governFeatureCreate(CommandSender sender, String govern_name, String feature_name){
        try {
            assert GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name) != null;
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
            return;
        }
        GovernFeature govern = new GovernFeature();
        govern.setGovern(govern_name);
        govern.setName(feature_name);
        govern.setDisplayName(govern_name);
        govern.setDescription("");
        govern.setIcon("STONE_AXE");
        govern.setX(1);
        govern.setY(1);
        try {
            GovernsPlugin.getInstance().getGovernFeatureDao().create(govern);
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            sender.sendMessage(ChatUtils.translate(Messages.success));
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
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
            StringBuilder out = new StringBuilder();
            for (GovernFeature feat : govern_feats) {
                out.append(feat.getName()).append(" ");
            }
            sender.sendMessage("List: " + out);
        } catch (SQLException e) {
            e.printStackTrace();
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("governs_get_all")
    public void getAllGoverns(CommandSender sender){
        StringBuilder out = new StringBuilder();
        try {
            for (Govern govern : GovernsPlugin.getInstance().getGovernDao().queryForAll()) {
                out.append(govern.getName()).append(" ");
            }
            sender.sendMessage("List: " + out);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @CommandHook("govern_get")
    public void getGovern(CommandSender sender, String govern_name){
        try {
            Govern govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
            sender.sendMessage(ChatUtils.translate(Messages.govern_info)
                    .replaceAll("%name%", govern.getName())
                    .replaceAll("%display_name%", govern.getDisplayName())
                    .replaceAll("%description%", govern.getDescription())
                    .replaceAll("%x%", String.valueOf(govern.getBaseX()))
                    .replaceAll("%y%", String.valueOf(govern.getBaseY()))
                    .replaceAll("%z%", String.valueOf(govern.getBaseZ()))
                    .replaceAll("%icon%", govern.getIcon())
                    .replaceAll("%approve%", String.valueOf(govern.isApprove())));
        } catch (Exception e) {
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                                e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("govern_feat_get")
    public void getGovernFeat(CommandSender sender, String govern_name, String feature_name){
        try {
            QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
            Where<GovernFeature, String> where = qb.where();
            where.eq("govern", govern_name);
            where.and();
            where.eq("name", feature_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            GovernFeature govern = GovernsPlugin.getInstance().getGovernFeatureDao().queryForFirst(preparedQuery);
            sender.sendMessage(ChatUtils.translate(Messages.feature_info)
                    .replaceAll("%name%", govern.getName())
                    .replaceAll("%display_name%", govern.getDisplayName())
                    .replaceAll("%description%", govern.getDescription())
                    .replaceAll("%govern%", String.valueOf(govern.getGovern()))
                    .replaceAll("%icon%", govern.getIcon()));
        } catch (Exception e) {
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("player_get")
    public void getPlayer(CommandSender sender, Player player){
        try {
            ru.firesquare.governs.sql.Player player1 = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
            sender.sendMessage(ChatUtils.translate(Messages.player_info)
                    .replaceAll("%nickname%", player.getName())
                    .replaceAll("%govern%", player1.getGovern()));
        } catch (Exception e) {
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("player_kick")
    public void kickPlayer(CommandSender sender, Player player){
        try {
            ru.firesquare.governs.sql.Player player1 = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
            player1.setGovern(null);
            GovernsPlugin.getInstance().getPlayerDao().update(player1);
        } catch (Exception e) {
            sender.sendMessage(ChatUtils.translate(Messages.error) +
                    e.getMessage().replace('\n', ' '));
        }
    }

    @CommandHook("clan_chat")
    public void clanChat(CommandSender sender, String message){
        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();

        ru.firesquare.governs.sql.Player sender_db;
        try {
            sender_db = GovernsPlugin.getInstance().getPlayerDao().queryForId(sender.getName());
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        String rendered_message = ChatUtils.translate(Messages.clan_chat)
                .replaceAll("%govern%", sender_db.getGovern())
                .replaceAll("%player%", sender.getName())
                .replaceAll("%message%", message);

        for(Player player : players) {
            ru.firesquare.governs.sql.Player player_db;
            try {
                player_db = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
            } catch (SQLException e) {
                e.printStackTrace();
                continue;
            }

            if(Objects.equals(player_db.getGovern(), sender_db.getGovern())) {
                player.sendMessage(rendered_message);
            }
        }
    }
}
