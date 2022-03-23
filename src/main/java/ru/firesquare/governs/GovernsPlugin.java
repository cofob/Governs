package ru.firesquare.governs;

import org.bukkit.plugin.java.JavaPlugin;

import ru.firesquare.governs.commands.ExampleCommand;
import ru.firesquare.governs.listeners.PlayerJoinListener;
import ru.firesquare.governs.tasks.ExampleTask;

public class GovernsPlugin extends JavaPlugin {
    
    @Override
    public void onEnable () {
        // Save default config
        this.saveDefaultConfig();

        // Set static instance
        ru.firesquare.governs.GovernsPlugin.instance = this;

        // Register the example command
        this.getCommand("example").setExecutor(new ExampleCommand());
        
        // Register the example listener
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Register the example task
        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new ExampleTask(), taskRepeatEvery, taskRepeatEvery);
    }

    private static ru.firesquare.governs.GovernsPlugin instance;

    public static ru.firesquare.governs.GovernsPlugin getInstance () {
        return ru.firesquare.governs.GovernsPlugin.instance;
    }
}