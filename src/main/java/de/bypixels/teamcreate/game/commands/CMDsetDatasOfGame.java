package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class CMDsetDatasOfGame implements CommandExecutor {


    //Setzt einige Daten über die Arena
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("DataOfGame")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.hasPermission("dataofgame")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("boundaryOfMinecartSpawn")) {
                            DataAboutGame.setBoundaryOfMinecartSpawn(Integer.valueOf(args[1]));
                            DataAboutGame.cfg.set("boundaryOfMinecartSpawn", args[1]);
                            try {
                                DataAboutGame.cfg.save(DataAboutGame.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MainSystem.PREFIX + "Du hast die Boundary der Minecarts auf: " + args[1] + " gesetzt!");

                        } else if (args[0].equalsIgnoreCase("highToWinGame")) {
                            DataAboutGame.setHighToWinGame(Integer.valueOf(args[1]));
                            DataAboutGame.cfg.set("highToWinGame", args[1]);
                            try {
                                DataAboutGame.cfg.save(DataAboutGame.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MainSystem.PREFIX + "Du hast die höhe zum Gewinnen auf: " + args[1] + " gesetzt!");

                        } else if (args[0].equalsIgnoreCase("timeBetweenMinecartSpawn")) {
                            DataAboutGame.setTimeBetweenMinecartSpawn(Integer.valueOf(args[1]));
                            DataAboutGame.cfg.set("timeBetweenMinecartSpawn", args[1]);
                            try {
                                DataAboutGame.cfg.save(DataAboutGame.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MainSystem.PREFIX + "Du hast die Boundary der Minecarts auf: " + args[1] + " gesetzt!");

                        } else if (args[0].equalsIgnoreCase("fallSpeedOfMinecart")) {
                            DataAboutGame.setFallSpeedOfMinecart(Integer.valueOf(args[1]));
                            DataAboutGame.cfg.set("fallSpeedOfMinecart", args[1]);
                            try {
                                DataAboutGame.cfg.save(DataAboutGame.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MainSystem.PREFIX + "Du hast die Fallgeschwindigkeit der Minecarts auf: " + args[1] + " gesetzt!");

                        }else if (args[0].equalsIgnoreCase("amountOfSpawnedMinecarts")) {
                            DataAboutGame.setAmountOfSpawnedMinecarts(Integer.valueOf(args[1]));
                            DataAboutGame.cfg.set("amountOfSpawnedMinecarts", args[1]);
                            try {
                                DataAboutGame.cfg.save(DataAboutGame.file);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MainSystem.PREFIX + "Du hast die Anazahl der spawnenden Minecarts auf: " + args[1] + " gesetzt!");

                        }

                    }else {
                        player.sendMessage(MainSystem.PREFIX+"Bitte benutze /dataofgame [boundaryOfMinecartSpawn, highToWinGame, timeToSpawnMinecart, fallSpeedOfMinecart] + WERT (Bei fallSpeedOfMinecart handelt es sich um einen float!) ");

                    }
                }
            }
        }
        return false;
    }
}
