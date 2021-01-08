package com.exmogamers.hardcoreadventureitems;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("setitem")) {
            if (((Player) commandSender).hasPermission("hardcoreadventureitems.setitem")) {
                Player player = (Player) commandSender;
                Main.mainInstance.getConfig().set("revive-item", player.getItemInHand().getType().toString());
                player.sendMessage("Revive Item Set to " + player.getItemInHand().getType());
                Main.mainInstance.getConfig().options().copyDefaults(true);
                Main.mainInstance.saveConfig();
            } else {
                commandSender.sendMessage("You do not have the right permissions");
            }
        }


        return false;
    }
}
