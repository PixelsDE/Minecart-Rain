package de.bypixels.teamcreate.game.commands;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class CMDremove implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if (command.getName().equalsIgnoreCase("removeminecarts")){
           if (sender instanceof Player){
               Player player = (Player) sender;
               if (player.hasPermission("removeminecarts")){
                   for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()){
                       if (minecart instanceof Minecart){
                           minecart.remove();
                       }
                   }
               }
           }
       }

        return false;
    }
}