package ru.firesquare.governs.menus;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.sql.Govern;
import ru.firesquare.governs.sql.GovernFeature;
import ru.firesquare.governs.utils.ChatUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GovernFeatsMenu implements InventoryProvider {
    private final String govern_name;

    public static SmartInventory build(String govern_name) {
        return SmartInventory.builder()
                .provider(new GovernFeatsMenu(govern_name))
                .size(3, 9)
                .title(ChatUtils.translate(Messages.join_govern_title))
                .closeable(true)
                .build();
    }

    public GovernFeatsMenu(String govern_name) {
        this.govern_name = govern_name;
    }

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)));

        Govern govern;
        try {
            govern = GovernsPlugin.getInstance().getGovernDao().queryForId(govern_name);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        QueryBuilder<GovernFeature, String> qb = GovernsPlugin.getInstance().getGovernFeatureDao().queryBuilder();
        Where<GovernFeature, String> where = qb.where();
        List<GovernFeature> feats;
        try {
            where.eq("govern", govern_name);
            PreparedQuery<GovernFeature> preparedQuery = qb.prepare();
            feats = GovernsPlugin.getInstance().getGovernFeatureDao().query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        for (GovernFeature feat : feats) {
            ItemStack item = new ItemStack(Objects.requireNonNull(Material.getMaterial(feat.getIcon())));
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            meta.setDisplayName(feat.getDisplayName());
            meta.setLore(Arrays.stream(feat.getDescription().split("%n")).toList());
            item.setItemMeta(meta);
            contents.set(feat.getY(), feat.getX(), ClickableItem.empty(item));
        }

        // Create buttons
        // "Join" button
        ItemStack item = new ItemStack(Objects.requireNonNull(Material.getMaterial(Messages.join_button_item)));
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatUtils.translate(Messages.join_button));
        item.setItemMeta(meta);
        contents.set(2, 7, ClickableItem.of(item, e -> {
            ru.firesquare.governs.sql.Player player1;
            try {
                player1 = GovernsPlugin.getInstance().getPlayerDao().queryForId(player.getName());
                player1.setGovern(govern_name);
                GovernsPlugin.getInstance().getPlayerDao().update(player1);
                User user = GovernsPlugin.getLuckPerms().getPlayerAdapter(Player.class).getUser(player);
                user.data().add(Node.builder("group." + govern_name + "-citizen").build());
                GovernsPlugin.getLuckPerms().getUserManager().saveUser(user);

                player.closeInventory();
                player.teleport(new Location(Bukkit.getWorld("world"), govern.getBaseX(), govern.getBaseY(), govern.getBaseZ()));
                player.setBedSpawnLocation(new Location(Bukkit.getWorld("world"), govern.getBaseX(), govern.getBaseY(), govern.getBaseZ()));
                player.sendTitle(ChatUtils.translate(Messages.joined_title),
                        ChatUtils.translate(Messages.joined_subtitle),
                        Messages.joined_fade_in, Messages.joined_stay, Messages.joined_fade_out);
                player.setGameMode(GameMode.SURVIVAL);
            } catch (SQLException ex) {
                ex.printStackTrace();
                player.sendMessage(ChatUtils.translate(Messages.error + "Failed to join!"));
                player.closeInventory();
            }
        }));

        // Back button
        item = new ItemStack(Objects.requireNonNull(Material.getMaterial(Messages.back_button_item)));
        meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatUtils.translate(Messages.back_button));
        item.setItemMeta(meta);
        contents.set(2, 6, ClickableItem.of(item, e -> JoinGovernMenu.INVENTORY.open(player)));
    }

    @Override
    public void update(Player player, InventoryContents contents) {}
}
