package de.bypixels.teamcreate.game.events;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 09.05.2018 / 20:48                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/


public class PlayerHitGround implements Listener {


    //Teleportiert den Spieler zur DeathLoc wenn er unter Y... kommt
    @EventHandler(ignoreCancelled = true)
    public void onDroponGround(de.bypixels.teamcreate.game.util.api.specialEvents.PlayerDropOnGround event) {
        Player player = event.getPlayer();
        MainSystem.isPlaying.remove(player);
        World world = Bukkit.getWorld(DataAboutArena.getDeathWorldName());
        Location location = new Location(world, DataAboutArena.getDeathWorldX(), DataAboutArena.getDeathWorldY(), DataAboutArena.getDeathWorldZ());
        player.teleport(location);
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(MainSystem.PREFIX + "§cDer Spieler: §6" + player.getName() + "§c ist ausgeschieden!");
        }
        player.sendMessage(MainSystem.PREFIX + "§7Du bist ausgeschienden!");
        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND,  99, 1);
        MainSystem.isPlaying.remove(player);
        //Nachricht wenn nur noch 1 Spieler am Leben ist!
        String winnerName;
        if (MainSystem.isPlaying.size() == 1) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendMessage(MainSystem.getPREFIX() + "§7Der Spieler: §6" + MainSystem.isPlaying.get(0).getName() + " §7hat gewonnen!");
            }
        }
        if (MainSystem.isPlaying.size() == 0){
            Bukkit.getScheduler().scheduleSyncDelayedTask(MainSystem.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoprain");

                }
            },40);
        }
    }
}
