package ru.firesquare.governs.expansions;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.sql.Govern;
import ru.firesquare.governs.sql.Player;

import java.sql.SQLException;

public class PlayerGovernExpansion extends PlaceholderExpansion {
    public PlayerGovernExpansion() {}

    @Override
    public @NotNull String getAuthor() {
        return "firesquare";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "governs";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("player_govern")) {
            Player player_db;
            Govern govern;
            try {
                player_db = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
                govern = GovernsPlugin.getInstance().getGovernDao().queryForId(player_db.getGovern());
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return player_db.getGovern() == null ? null : ChatColor.translateAlternateColorCodes('&', govern.getDisplayName()); // "name" requires the player to be valid
        }

        return null;
    }
}
