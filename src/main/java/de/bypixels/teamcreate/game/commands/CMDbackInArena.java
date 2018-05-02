package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class CMDbackInArena implements CommandExecutor {


    //Command der die Location setzt wo die Spieler hinkommen nach dem Spiel
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("backinarena")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.hasPermission("backinarena")) {
                    DataAboutArena.setBackInArenaX(player);
                    DataAboutArena.setBackInArenaY(player);
                    DataAboutArena.setBackInArenaZ(player);
                    DataAboutArena.setBackInArenaWorldName(player.getWorld().getName());
                    DataAboutArena.setBackInArenaLocInConfig();
                    player.sendMessage(MainSystem.PREFIX + "§7Du hast die Location wo die Spieler nach dem Spiel hinkommen gesetzt!");

                }
            }
        }

        return false;
    }
}
