package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.SetPlayerInMinecart;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 08:37                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class CMDteleportInMinecart implements CommandExecutor {

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("teleportinminecart")){
            if (sender instanceof Player){
                Player player = (Player)sender;
                if (player.hasPermission("teleportinminecart")){
                    for (Player allPlayers: Bukkit.getOnlinePlayers()) {
                        MainSystem.setStart(true);
                        SetPlayerInMinecart playerInMinecart = new SetPlayerInMinecart(allPlayers);

                    }
                }
            }
        }

        return false;
    }
}
