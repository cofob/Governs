package ru.firesquare.governs.menus;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.sql.Govern;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoinGovernMenu implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("JoinGovern")
            .provider(new JoinGovernMenu())
            .size(3, 9)
            .title(ChatColor.translateAlternateColorCodes('&', Messages.join_govern_title))
            .closeable(true)
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)));

        int i = 1;
        try {
            for (Govern govern : GovernsPlugin.getInstance().getGovernDao().queryForAll()) {
                ItemStack item = new ItemStack(Objects.requireNonNull(Material.getMaterial(govern.getIcon())));
                ItemMeta meta = item.getItemMeta();
                assert meta != null;
                meta.setDisplayName(govern.getDisplayName());
                meta.setLore(Arrays.stream(govern.getDescription().split("%n"))
                        .map(e -> ChatColor.translateAlternateColorCodes('&', e)).collect( Collectors.toList() ));
                item.setItemMeta(meta);
                contents.set(1, i, ClickableItem.of(item, e -> player.closeInventory()));
                i += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        int state = contents.property("state", 0);
        contents.setProperty("state", state + 1);

        if(state % 5 != 0)
            return;

        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        contents.fillBorders(ClickableItem.empty(glass));
    }

}
