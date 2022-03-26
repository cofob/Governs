package ru.firesquare.governs;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.commandmanager.CommandParser;
import redempt.redlib.config.ConfigManager;
import redempt.redlib.dev.ChainCommand;
import redempt.redlib.dev.StructureTool;
import ru.firesquare.governs.commands.GovernsCommand;
import ru.firesquare.governs.config.Config;
import ru.firesquare.governs.config.Messages;
import ru.firesquare.governs.listeners.PlayerJoinListener;
import ru.firesquare.governs.listeners.PlayerLeaveSpawnListener;
import ru.firesquare.governs.sql.Govern;
import ru.firesquare.governs.sql.GovernFeature;
import ru.firesquare.governs.sql.Player;
import ru.firesquare.governs.tasks.RememberJoinGovernTask;

import java.sql.SQLException;

public class GovernsPlugin extends JavaPlugin {
    @Override
    public void onEnable () {
        // Load config
        ConfigManager.create(this).target(Config.class).saveDefaults().load();
        ConfigManager.create(this, "lang.yml").target(Messages.class).saveDefaults().load();

        // Load messages
        reloadFileConfig();

        // Set static instance
        GovernsPlugin.instance = this;

        // Load and init SQL
        initSQL();

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

        // Register tasks
        final long taskRepeatEvery = Messages.join_remember_retry_every * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new RememberJoinGovernTask(), taskRepeatEvery, taskRepeatEvery);
    }

    private Dao<Govern, String> governDao;
    private Dao<GovernFeature, String> governFeatureDao;
    private Dao<Player, String> playerDao;

    public void initSQL() {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource(Config.database);

            // instantiate the dao's
            governDao = DaoManager.createDao(connectionSource, Govern.class);
            governFeatureDao = DaoManager.createDao(connectionSource, GovernFeature.class);
            playerDao = DaoManager.createDao(connectionSource, Player.class);

            // create tables
            TableUtils.createTableIfNotExists(connectionSource, Govern.class);
            TableUtils.createTableIfNotExists(connectionSource, GovernFeature.class);
            TableUtils.createTableIfNotExists(connectionSource, Player.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reloadFileConfig() {
        ConfigManager.create(this, "lang.yml").target(Messages.class).saveDefaults().reload();
        ConfigManager.create(this).target(Config.class).saveDefaults().reload();
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

    public Dao<Govern, String> getGovernDao() {
        return governDao;
    }

    public Dao<Player, String> getPlayerDao() {
        return playerDao;
    }

    public Dao<GovernFeature, String> getGovernFeatureDao() {
        return governFeatureDao;
    }
}