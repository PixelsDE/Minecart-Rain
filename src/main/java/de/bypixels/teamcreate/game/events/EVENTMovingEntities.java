package de.bypixels.teamcreate.game.events;

import org.bukkit.event.Listener;

/**
 * Made by PixelsDE
 * +* Minecraft-Developer
 * +* (c) PixelsDE 2018
 * +* https://youtube.com/bypixels/
 * +
 */

public class EVENTMovingEntities implements Listener {

/*
    @EventHandler(ignoreCancelled = true)
    public void onPlayerMove(final PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (MainSystem.isPlaying.contains(player)) {

            if (StartMinecartRain.whereHashMap.containsKey(player)) {
                if (player.getLocation().getY() > StartMinecartRain.whereHashMap.get(player).getY() + MainSystem.dataAboutGame.getDataInt("high_to_win")) {
                    player.sendMessage("You are Good!");
                    MainSystem.isPlaying.remove(player);
                    player.teleport(StartMinecartRain.whereHashMap.get(player));


                }
            }
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onVehicleMove(final VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || event.getVehicle().getLocation().getY() <= DataAboutArena.cfg.getDouble("boundloc")) {
                event.getVehicle().remove();
            }
        }
    }




    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setDeathMessage(null);
    }


    @EventHandler(ignoreCancelled = true)
    public void onMinecartMove(VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            Minecart minecart = (Minecart) event.getVehicle();
            minecart.setMaxSpeed(MainSystem.dataAboutGame.getDataInt("fall_speed_minecart"));
            minecart.setVelocity(minecart.getVelocity().multiply(MainSystem.dataAboutGame.getDataInt("fall_speed_minecart")));

        }

    }*/
}
