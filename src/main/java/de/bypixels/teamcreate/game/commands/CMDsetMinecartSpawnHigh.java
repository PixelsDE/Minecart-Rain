package de.bypixels.teamcreate.game.commands;
/* Made by PixelsDE
 Minecraft-Developer
 Copyright PixelsDE
 youtube.com/bypixels */

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDsetMinecartSpawnHigh implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("highminecartspawn")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("highminecartspawn")) {

                        DataAboutArena.setHighWhereMinecartsSpawn(player);

                        DataAboutArena.setMinecartSpawnHighInConfig();
                        player.sendMessage(MainSystem.PREFIX+"§7Du hast die Höhe der Minecarts zum Spawnen gesetzt!");
                    }
                }
            }


        return false;
    }
}
