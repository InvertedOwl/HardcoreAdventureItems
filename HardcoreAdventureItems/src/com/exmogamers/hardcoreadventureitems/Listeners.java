package com.exmogamers.hardcoreadventureitems;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Listeners implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        event.getEntity().setGameMode(GameMode.ADVENTURE);
    }

    @EventHandler
    public void onPickup(PlayerPickupItemEvent event){
        if(event.getItem().getItemStack().getType().equals(Material.getMaterial(Main.mainInstance.getConfig().get("revive-item").toString()))){
            if((event.getPlayer().getGameMode() == GameMode.ADVENTURE)){
                event.getPlayer().setGameMode(GameMode.SURVIVAL);
                event.getPlayer().sendTitle("You Have Been §aRevived", "", 10, 80, 10);
                event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
            }
        }
    }
}
