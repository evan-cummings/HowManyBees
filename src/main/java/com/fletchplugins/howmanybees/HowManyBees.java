package com.fletchplugins.howmanybees;


import org.bukkit.plugin.java.JavaPlugin;

public final class HowManyBees extends JavaPlugin {
    ItemListener itemListener=new ItemListener();
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(itemListener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
