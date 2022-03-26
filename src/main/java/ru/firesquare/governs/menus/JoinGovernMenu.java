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
import ru.firesquare.governs.utils.ChatUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JoinGovernMenu implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("JoinGovern")
            .provider(new JoinGovernMenu())
            .size(3, 9)
            .title(ChatUtils.translate(Messages.join_govern_gui_title))
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
                        .map(e -> ChatUtils.translate(e)).collect( Collectors.toList() ));
                item.setItemMeta(meta);
                contents.set(1, i, ClickableItem.of(item, e -> GovernFeatsMenu.build(govern.getName()).open(player)));
                i += 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {}
}
