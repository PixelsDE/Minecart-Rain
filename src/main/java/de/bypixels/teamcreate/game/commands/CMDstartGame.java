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
import de.bypixels.teamcreate.game.util.*;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDstartGame implements CommandExecutor {
    private int TaskID;
    //Startet das Spiel
    @Deprecated
    @Override
    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("start")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (!BanishedPlayers.getBanishedPlayers().contains(all.getName()))
                            MainSystem.isPlaying.add(all);
                        all.sendMessage(MainSystem.PREFIX + "§aDas Spiel hat begonnen viel Glück!");
                        all.teleport(DataAboutArena.getArenaMiddle());
                        MainSystem.setStart(false);
                    }
                    MinecartRain.startMinecartRain();
                    TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainSystem.getPlugin(), new Runnable() {
                        int i = DataAboutGame.getTimeBeforeSetInMinecart();

                        @Override
                        public void run() {
                            switch (i) {
                                case 30:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);}
                                    break;
                                case 20:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);}
                                    break;
                                case 10:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);}
                                    break;
                                case 5:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);}
                                    break;
                                case 4:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1); }
                                    break;
                                case 3:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
                                    }
                                    break;
                                case 2:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunden!");

                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);}
                                    break;
                                case 1:
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX() + "§7Das Spiel startet in: " + i + " Sekunde!");
                                        all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
                                    }
                                    break;
                                case 0:
                                    MainSystem.setStart(true);
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(MainSystem.getPREFIX()+"§7Das Spiel beginnt. Viel Glück!");
                                        if (!BanishedPlayers.getBanishedPlayers().contains(all.getName())) {
                                          new SetPlayerInMinecart(all);
                                        }
                                    }
                                    Bukkit.getScheduler().cancelTask(TaskID);
                                    break;
                                default:
                                    break;
                            }
                            i = i - 1;
                        }
                    }, 20, 20);
                }

            }
        }
        return false;
    }


}
