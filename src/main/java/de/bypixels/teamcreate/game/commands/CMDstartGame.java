package de.bypixels.teamcreate.game.commands;

/******************************************************************
 *   Copyright Notice                                             *
 *   Copyright (c) PixelsDE | Daniel 2018                         *
 *   Created: 05.05.2018 / 11:59                                  *
 *   All contents of this source text are protected by copyright. *
 *   The copyright law, unless expressly indicated otherwise, is  *
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            *
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/


import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import de.bypixels.teamcreate.game.util.MinecartRain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDstartGame implements CommandExecutor {

    //Startet das Spiel
    @Override
    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("start")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        MainSystem.isPlaying.add(all);
                        all.sendMessage(MainSystem.PREFIX + "§aDas Spiel hat begonnen viel Glück!");
                        all.teleport(DataAboutArena.getArenaMiddle());
                    }

                    MinecartRain.startMinecartRain();

            /*        for (Player all : Bukkit.getOnlinePlayers())
                        MinecartRain.setPlayerInMinecart(all);
                */}
                //Delay bevor das Spiel beginnt

            }
        }

        return false;
    }


}
