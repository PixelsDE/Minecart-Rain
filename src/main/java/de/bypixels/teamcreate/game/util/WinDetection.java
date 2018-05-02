package de.bypixels.teamcreate.game.util;
/* Made by PixelsDE
 Minecraft-Developer
 Copyright PixelsDE
 youtube.com/bypixels */

import de.bypixels.teamcreate.game.main.MainSystem;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WinDetection {



    public static ArrayList<Player> winners = new ArrayList<>();
    //Method that gives you the winning Player
    public static boolean checkForWin(Player player) {
            if (MainSystem.isPlaying.contains(player)) {
                if (player.getLocation().getY() >= DataAboutGame.getHighToWinGame()) {
                    if (!winners.contains(player)) {
                        winners.add(player);
                        return true;
                    }
                }
            }

        return false;
    }
}
