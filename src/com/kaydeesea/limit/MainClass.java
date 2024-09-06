package com.kaydeesea.limit;

import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();
        getServer().getPluginManager().registerEvents(new LimitManager(), this);

    }
}
