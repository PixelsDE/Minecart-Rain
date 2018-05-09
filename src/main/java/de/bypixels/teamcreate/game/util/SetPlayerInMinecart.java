package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

import java.util.List;

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


    @Deprecated
    public SetPlayerInMinecart(Player player) {
        boolean found = false;
        for (int i = 0; i < 200; i++) {
            List<Entity> entities = player.getNearbyEntities(i,64,i);
            for (Entity e : entities) {
                if (e.getType().equals(EntityType.MINECART)) {
                    e.getVehicle().setPassenger(player);
//do compas thing for that player, also post that code, i would be interested in it..
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

    }


}

