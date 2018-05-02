package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class CMDsetArena implements CommandExecutor {


    //Setzt den Mittelpunkt der Arena

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("setarena")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("setarena")){

                   DataAboutArena.setArenaBoundX(player);
                   DataAboutArena.setArenaBoundZ(player);
                   DataAboutArena.setArenaWorld(player.getWorld().getName());

                    DataAboutArena.setArenaInConfig();

                    player.sendMessage(MainSystem.PREFIX+"§7DU hast die Arenamitte gesetzt!");

                }
            }
        }
        return false;
    }
}
