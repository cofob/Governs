package ru.firesquare.governs;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.commandmanager.CommandParser;
import redempt.redlib.commandmanager.Messages;
import redempt.redlib.config.ConfigManager;
import redempt.redlib.dev.ChainCommand;
import redempt.redlib.dev.StructureTool;
import ru.firesquare.governs.commands.GovernsCommand;
import ru.firesquare.governs.config.Config;
import ru.firesquare.governs.listeners.PlayerJoinListener;
import ru.firesquare.governs.listeners.PlayerLeaveSpawnListener;
import ru.firesquare.governs.sql.SQLManager;
import ru.firesquare.governs.tasks.ExampleTask;
import xyz.janboerman.guilib.GuiLibrary;
import xyz.janboerman.guilib.api.GuiListener;

public class GovernsPlugin extends JavaPlugin {
    @Override
    public void onEnable () {
        // Load config
        ConfigManager.create(this).target(Config.class).saveDefaults().load();

        // Load messages
        reloadFileConfig();

        // Set static instance
        GovernsPlugin.instance = this;

        // Load and init SQL
        SQLManager manager = new SQLManager();
        manager.initialize();

        // Register the commands
        ChainCommand chain = new ChainCommand();
        new CommandParser(this.getResource("command.rdcml"))
                .parse()
                .register("governs", new GovernsCommand(), StructureTool.enable(), chain);
        
        // Register listeners
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        new PlayerLeaveSpawnListener();

        // Setup Vault
        setupPermissions();

        // Setup GuiLib
        GuiLibrary guiLibrary = (GuiLibrary) getServer().getPluginManager().getPlugin("GuiLib");
        guiListener = guiLibrary.getGuiListener();

        // Register the example task
        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new ExampleTask(), taskRepeatEvery, taskRepeatEvery);
    }

    public void reloadFileConfig () {
        Messages.load(this);
    }

    private static Permission perms = null;

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        assert rsp != null;
        perms = rsp.getProvider();
    }

    public static Permission getPermissions() {
        return perms;
    }

    private static ru.firesquare.governs.GovernsPlugin instance;

    public static ru.firesquare.governs.GovernsPlugin getInstance () {
        return ru.firesquare.governs.GovernsPlugin.instance;
    }

    private GuiListener guiListener;

    public GuiListener getGuiListener() {
        return guiListener;
    }
}