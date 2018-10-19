package de.bypixels.teamcreate.game.events;
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
import de.bypixels.teamcreate.game.util.api.specialEvents.PlayerWinEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class WinPlayerMove implements Listener {


    //
    @EventHandler
    public void onPlayerMoveToWin(PlayerWinEvent event) {
        Player player = event.getPlayer();
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(MainSystem.PREFIX + "§7Der Spieler: §6" + player.getName() + " §7hat das Ziel erreicht!");
        }

        //Fügt den Spieler in die Winnerliste ein!
        MainSystem.winner.add(event.getPlayer());
        if (!MainSystem.winner.contains(event.getPlayer()))
            MainSystem.winner.add(event.getPlayer());




        World world = Bukkit.getWorld(DataAboutArena.getBackInArenaWorldName());
        Location backInGameLoc = new Location(world, DataAboutArena.getBackInArenaX(), DataAboutArena.getBackInArenaY(), DataAboutArena.getBackInArenaZ());

        //Teleports the Player back into the old Arena.
        player.teleport(backInGameLoc);

        player.sendMessage(MainSystem.PREFIX + "§7Du hast gewonnen und bist zurück im Spiel!");

        MainSystem.isPlaying.remove(player);

        if (MainSystem.winner.size() == DataAboutGame.getAmountOfPlayerToStop() || MainSystem.isPlaying.isEmpty()) {

            Bukkit.getScheduler().scheduleSyncDelayedTask(MainSystem.getPlugin(), new Runnable() {

                @Override
                public void run() {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stoprain");
                }

            }, 40);

        }

        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);

    }






}
