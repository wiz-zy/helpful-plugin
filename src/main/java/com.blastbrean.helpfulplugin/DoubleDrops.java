package com.blastbrean.helpfulplugin;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import java.util.Random;

public class DoubleDrops implements Listener {
    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block blockBroken = event.getBlock();
        PlayerInventory i = player.getInventory();
        Random rand = new Random();
        int random = rand.nextInt(100);
        if (random < 10) {
            if (blockBroken.getType() == Material.COAL_ORE ||
                blockBroken.getType() == Material.IRON_ORE ||
                blockBroken.getType() == Material.GOLD_ORE ||
                blockBroken.getType() == Material.DIAMOND_ORE ||
                blockBroken.getType() == Material.ANCIENT_DEBRIS ||
                blockBroken.getType() == Material.STONE) {
                // ----------------------------------------------- //
                if ((player.hasPermission("fortuneblocks.use")) && (player.getGameMode().equals(GameMode.SURVIVAL))) {
                    if (i.getItemInMainHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)) {
                        int fortune = i.getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                        System.out.println("[HelpfulPlugin] Double Drops: Using " + i.getItemInMainHand());
                        System.out.println("[HelpfulPlugin] Double Drops: Broke " + blockBroken.getType() + " | Fortune level is " + fortune);
                        Material oldBlockBroken = blockBroken.getType();
                        event.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        System.out.println("[HelpfulPlugin] Double Drops: Set Dropped Items to False, set type to AIR.");
                        ItemStack ore = new ItemStack(oldBlockBroken, 2 * fortune);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), ore);
                    } else {
                        System.out.println("[HelpfulPlugin] Double Drops: Using " + i.getItemInMainHand());
                        System.out.println("[HelpfulPlugin] Double Drops: Broke " + blockBroken.getType() + " | User doesn't have fortune.");
                        Material oldBlockBroken = blockBroken.getType();
                        event.setDropItems(false);
                        blockBroken.setType(Material.AIR);
                        System.out.println("[HelpfulPlugin] Double Drops: Set Dropped Items to False, set type to AIR.");
                        ItemStack ore = new ItemStack(oldBlockBroken, 2);
                        blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), ore);
                        System.out.println("[HelpfulPlugin] Double Drops: Dropped ore naturally.");
                    }
                }
            }
        }
    }
}
