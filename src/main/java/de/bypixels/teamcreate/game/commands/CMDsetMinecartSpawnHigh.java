package de.bypixels.teamcreate.game.commands;
/* Made by PixelsDE
 Minecraft-Developer
 Copyright PixelsDE
 youtube.com/bypixels */

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CMDsetMinecartSpawnHigh implements CommandExecutor {



    //Command der die Höhe der Minecarts zum Spawnen setzt
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("highminecartspawn")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("highminecartspawn")) {

                    DataAboutGame.setHighWhereMinecartsSpawn(player);
                    DataAboutGame.cfg.set("highWhereMinecartsSpawn", (int) player.getLocation().getY());
                    try {
                        DataAboutGame.cfg.save(DataAboutGame.file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        player.sendMessage(MainSystem.PREFIX+"§7Du hast die Höhe der Minecarts zum Spawnen gesetzt!");
                    }
                }
            }


        return false;
    }
}
