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
import de.bypixels.teamcreate.game.util.MinecartRain;
import de.bypixels.teamcreate.game.util.SortedHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

import java.security.KeyStore;
import java.util.*;

public class CMDstopGame implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("stoprain")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("stoprain")) {
                    done();
                } else {
                    //If no Permission!

                    player.sendMessage(MainSystem.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");

                }
            } else {
                done();
                Bukkit.getConsoleSender().sendMessage(MainSystem.getPREFIX() + "§cDas Spiel wurde erfolgreich gestoppt!");
            }
        }
        return false;
    }


    private void done() {
        Bukkit.getScheduler().cancelTask(MinecartRain.TaskID);
        for (Entity entity : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
            if (entity instanceof Minecart) {
                entity.remove();
            }
        }
        SortedHashMap.sortTheMap();
        MainSystem.setStart(false);
        for (Player all : Bukkit.getOnlinePlayers()) {




            World world = Bukkit.getWorld(DataAboutArena.getBackInArenaWorldName());
            Location backInGameLoc = new Location(world, DataAboutArena.getBackInArenaX(), DataAboutArena.getBackInArenaY(), DataAboutArena.getBackInArenaZ());
            Bukkit.getScheduler().scheduleSyncDelayedTask(MainSystem.getPlugin(), new Runnable() {
                @Override
                public void run() {

                    //Teleportiert die Spieler wieder in die Arena
                    all.teleport(backInGameLoc);

                    Bukkit.getScheduler().cancelTask(MinecartRain.TaskID);
                    all.sendMessage(MainSystem.getPREFIX() + "§7Danke, dass du §6"+all.getName()+" §7gespielt hast!");
                    all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
                    MainSystem.winner.remove(all);

                    MainSystem.isPlaying.remove(all);


                    //Reloadet den Server!
                    MainSystem.getPlugin().getServer().reload();
                    System.out.println(MainSystem.getPREFIX()+ "§aDer Server wurde erfolgreich reloadet!");
                }
            }, 5);


        }

    }
}
