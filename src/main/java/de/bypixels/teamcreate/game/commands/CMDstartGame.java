package de.bypixels.teamcreate.game.commands;

// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /


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