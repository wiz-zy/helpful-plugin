package com.blastbrean.helpfulplugin;

import com.blastbrean.helpfulplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[HelpfulPlugin] has started.");
        getServer().getPluginCommand("broadcast").setExecutor(new BroadcastCommand(this));
        getServer().getPluginCommand("heal").setExecutor(new HealCommand(this));
        getServer().getPluginCommand("starve").setExecutor(new StarveCommand(this));
        getServer().getPluginCommand("setHealth").setExecutor(new setHealthCommand(this));
        getServer().getPluginCommand("hunger").setExecutor(new HungerCommand(this));
        getServer().getPluginManager().registerEvents(new DoubleDrops(), this);
        getServer().getPluginManager().registerEvents(new OPFood(), this);
        // getServer().getPluginManager().registerEvents(new FasterSmelting(), this);
        getServer().getPluginManager().registerEvents(new Berserk(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[HelpfulPlugin] has shutdown.");
    }
}
