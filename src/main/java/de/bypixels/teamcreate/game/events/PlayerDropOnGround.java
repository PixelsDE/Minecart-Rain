package de.bypixels.teamcreate.game.events;

import de.bypixels.teamcreate.game.main.MainSystem;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class PlayerDropOnGround implements Listener {



    //Teleportiert den Spieler zur DeathLoc wenn er unter Y... kommt
    @EventHandler(ignoreCancelled = true)
    public void onDroponGround(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (MainSystem.isPlaying.contains(player)) {
            if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                MainSystem.isPlaying.remove(player);
                World world = Bukkit.getWorld(DataAboutArena.getDeathWorldName());
                Location location = new Location(world , DataAboutArena.getDeathWorldX(), DataAboutArena.getDeathWorldY(), DataAboutArena.getDeathWorldZ());
                player.teleport(location);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(MainSystem.PREFIX + "§cDer Spieler: §6" + player.getName() + "§c ist ausgeschieden!");
                }
                player.sendMessage(MainSystem.PREFIX+"§7Du bist ausgeschienden!");

            }
        }
    }


}
