package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
  Made by PixelsDE
 Minecraft-Developer
  (c) PixelsDE 2018
   https://youtube.com/bypixels/
 */

public class CMDsetDeathLocation implements CommandExecutor {

    //Setzt die Location wo spieler hinkommen wenn sie raus sind
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("deathlocation")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("deathlocation")){

                    DataAboutArena.setDeathWorldName(player.getWorld().getName());
                    DataAboutArena.setDeathWorldX(player);
                    DataAboutArena.setDeathWorldY(player);
                    DataAboutArena.setDeathWorldZ(player);
                    DataAboutArena.setDeathLocInConfig();

                    player.sendMessage(MainSystem.PREFIX+"§7Du hast die Position gesetzt wo die Spieler hinkommen wenn sie tot sind!");
                }
            }
        }

        return false;
    }
}
