package ru.firesquare.governs.tasks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.utils.ChatUtils;

import java.sql.SQLException;
import java.util.Collection;

public class RememberJoinGovernTask implements Runnable {
    @Override
    public void run() {
        Collection<? extends Player> players = Bukkit.getServer().getOnlinePlayers();
        for(Player player : players) {
            ru.firesquare.governs.sql.Player player_db;
            try {
                player_db = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
            } catch (SQLException e) {
                e.printStackTrace();
                continue;
            }

            if(player_db.getGovern() == null) {
                player.sendMessage(ChatUtils.translate(Messages.join_remember));
            }
        }
    }
}