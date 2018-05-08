package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 08:22                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class SetPlayerInMinecart {


    private Player player;


    @Deprecated
    public SetPlayerInMinecart(Player player) {
        this.player = player;
        for (Entity nearbyEntities : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
            if (nearbyEntities instanceof Minecart) {
                Minecart minecart = (Minecart) nearbyEntities.getVehicle();
                Location location = new Location(player.getWorld()
                        , player.getLocation().getX()
                        ,player.getLocation().getY() + DataAboutGame.getHighPlayersTeleportetAfterStart()
                        , player.getLocation().getZ());
                player.teleport(location);
                if (player.getLocation().distance(minecart.getLocation()) <= 5) {
                    if (MainSystem.spawnedMinecarts.contains(minecart)) {
                        minecart.setPassenger(player);

                        MainSystem.setStart(true);
                    }
                }
            }
        }


    }


}

