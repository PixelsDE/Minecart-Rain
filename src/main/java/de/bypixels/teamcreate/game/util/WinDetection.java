package de.bypixels.teamcreate.game.util;
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
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WinDetection {


    public static ArrayList<Player> winners = new ArrayList<>();

    //Method that gives you the winning Player if the Player is above a special location it returns true
    public static boolean checkForWin(Player player) {
        if (MainSystem.isPlaying.contains(player)) {
            if (player.getLocation().getY() >= DataAboutGame.getHighToWinGame()) {
                if (!winners.contains(player)) {
                    winners.add(player);
                    MainSystem.isPlaying.remove(player);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
