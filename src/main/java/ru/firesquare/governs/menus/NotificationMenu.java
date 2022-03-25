package ru.firesquare.governs.menus;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import redempt.redlib.commandmanager.Messages;
import ru.firesquare.governs.GovernsPlugin;
import xyz.janboerman.guilib.api.menu.MenuHolder;

public class NotificationMenu extends MenuHolder<GovernsPlugin> implements Listener {
    private final String message;

    public NotificationMenu(int size, String title, String message) {
        super(GovernsPlugin.getInstance().getGuiListener(), GovernsPlugin.getInstance(), size, title);
        this.message = message;
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg(this.message)));
        super.onClose(event);
    }

    @Override
    public void onClick(InventoryCloseEvent event) {
        event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Messages.msg(this.message)));
        super.onClose(event);
    }
}
