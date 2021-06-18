package com.blastbrean.helpfulplugin.commands;

import com.blastbrean.helpfulplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {
    private final Main main;

    public BroadcastCommand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if(args.length == 0) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.RED + "Malformed arguments! Correct usage: /broadcast <msg>");
                return true;
            }

            if (args.length >= 1) {
                StringBuilder msgBuilder = new StringBuilder();
                for (String arg : args) {
                    msgBuilder.append(arg).append(" ");
                }
                String msg = "<BROADCAST> " + msgBuilder.toString();

                Player player = (Player) sender;
                for (int i = 0; i < 9; i++) {
                    switch(i) {
                        case 1:
                            Bukkit.broadcastMessage(ChatColor.RED + msg);
                            break;
                        case 2:
                            Bukkit.broadcastMessage(ChatColor.DARK_RED + msg);
                            break;
                        case 3:
                            Bukkit.broadcastMessage(ChatColor.YELLOW + msg);
                            break;
                        case 4:
                            Bukkit.broadcastMessage(ChatColor.AQUA + msg);
                            break;
                        case 5:
                            Bukkit.broadcastMessage(ChatColor.DARK_AQUA + msg);
                            break;
                        case 6:
                            Bukkit.broadcastMessage(ChatColor.GREEN + msg);
                            break;
                        case 7:
                            Bukkit.broadcastMessage(ChatColor.DARK_GREEN + msg);
                            break;
                        case 8:
                            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + msg);
                            break;
                        case 9:
                            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + msg);
                            break;
                    }
                }
            }
        } else {
            main.getLogger().info("Not a player. GTFO.");
        }
        return true;
    }

}

