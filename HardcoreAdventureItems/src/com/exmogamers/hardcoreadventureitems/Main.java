package com.exmogamers.hardcoreadventureitems;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Main mainInstance;
    public void onEnable() {
        if(this.getConfig().get("revive-item") == null){
            this.getConfig().set("revive-item", Material.STICK);
        }

        this.saveConfig();
        mainInstance = this;
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        this.getCommand("setitem").setExecutor(new Commands());
    }
    public void onDisable(){
        this.saveConfig();
    }
}
