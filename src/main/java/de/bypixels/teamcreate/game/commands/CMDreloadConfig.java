package de.bypixels.teamcreate.game.commands;
/*
 Made by PixelsDE
 Minecraft-Developer
 (c) PixelsDE 2018
 https://youtube.com/bypixels/
 */


import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMDreloadConfig implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("configreload")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;

                if (player.hasPermission("configreload")) {
                    DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.file);
                    DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.file);
                    player.sendMessage(MainSystem.PREFIX + "§7All Files Reloaded");
                }
            }else{
                DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.file);
                DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.file);
                Bukkit.getConsoleSender().sendMessage(MainSystem.PREFIX +"§7All Files Reloaded");
            }
        }
        return false;
    }
}
