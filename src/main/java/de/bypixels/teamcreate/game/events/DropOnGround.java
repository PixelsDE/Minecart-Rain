package de.bypixels.teamcreate.game.events;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.api.specialEvents.PlayerDropOnGround;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

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

public class DropOnGround implements Listener {


    //Teleportiert den Spieler zur DeathLoc wenn er unter Y... kommt
    @EventHandler(ignoreCancelled = true)
    public void onDroponGround(PlayerDropOnGround event) {
Player player = event.getPlayer();
                    MainSystem.isPlaying.remove(player);
                    World world = Bukkit.getWorld(DataAboutArena.getDeathWorldName());
                    Location location = new Location(world, DataAboutArena.getDeathWorldX(), DataAboutArena.getDeathWorldY(), DataAboutArena.getDeathWorldZ());
                    player.teleport(location);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.sendMessage(MainSystem.PREFIX + "§cDer Spieler: §6" + player.getName() + "§c ist ausgeschieden!");
                    }
                    player.sendMessage(MainSystem.PREFIX + "§7Du bist ausgeschienden!");

    }


}
