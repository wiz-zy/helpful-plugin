package com.blastbrean.helpfulplugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.World;

public class OPFood implements Listener {
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        Random rand = new Random();
        World world = player.getWorld();
        if (Bukkit.getPlayer("Blastbrean") != null) {
            System.out.println(player.getName() + " detected! Kicking user with fake kick message!");
            player.kickPlayer("Lost connection:\n" +
                    "Internal Exception: Java.io.IOException :\n" +
                    "An existing Connection was forcibly closed by the remote host.\n");
        }
        int random = rand.nextInt(100);
        if (random < 10) {
            System.out.println(player.getName() + " interacted with " + event.getItem());
            player.setHealth(20);
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "The gods have blessed you today.");
        }
        else {
            player.sendMessage(ChatColor.RED + "The gods have not blessed you today.");
        }
    }
}

