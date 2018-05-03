package de.bypixels.teamcreate.game.commands;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.MinecartRain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

public class CMDstopGame implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("stoprain")){
        if (sender instanceof Player) {
            Player player = (Player)sender;
            if (player.hasPermission("stoprain")){
                Bukkit.getScheduler().cancelTask(MinecartRain.TaskID);
                for (Entity entity : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()){
                    if (entity instanceof Minecart){
                        entity.remove();
                    }
                }
            }

        }
    }
        return false;
    }
}
