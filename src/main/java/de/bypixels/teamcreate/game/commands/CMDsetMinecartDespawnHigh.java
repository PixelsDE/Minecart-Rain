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

public class CMDsetMinecartDespawnHigh implements CommandExecutor {


    //Setzt die höhe wo Minecarts despawnen
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("minecartsdespawnhigh")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("minecartdespawnhigh")) {

                    DataAboutArena.setHighWhereMinecartsDespawn(player);
                    DataAboutArena.setMinecartsDespawnHighInConfig();

                    player.sendMessage(MainSystem.PREFIX+"§aDu hast die Boundary gesetzt!");

                }

            }

        }


        return false;

    }
}
