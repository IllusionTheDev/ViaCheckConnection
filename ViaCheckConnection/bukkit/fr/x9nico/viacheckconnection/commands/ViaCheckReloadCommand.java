package fr.x9nico.viacheckconnection.commands;

import fr.x9nico.viacheckconnection.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ViaCheckReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player)commandSender;
            if(command.getName().equalsIgnoreCase("viacheck")){
                    if(player.isOp() || player.hasPermission("viacheck.use")){
                        if(args.length == 0){
                            player.sendMessage("§cUsage: /viacheck <value>");
                        } else if(args[0].equalsIgnoreCase("reload")){
                            Main.getInstance().reloadConfig();
                            Main.getInstance().saveConfig();
                            player.sendMessage("§aThe config file has been updated on the server! Try now!");
                        }
                    } else {
                        player.sendMessage("You must be OP on the server for execute this command!");
                    }
                if(player.isOp() || player.hasPermission("viacheck.use")){
                    if(args.length == 0){
                        player.sendMessage("§cUsage: /viacheck <value>");
                    } else if(args[0].equalsIgnoreCase("reload")){
                        Main.getInstance().reloadConfig();
                        Main.getInstance().saveConfig();
                        player.sendMessage("§aThe config file has been updated on the server! Try now!");
                    }
                } else {
                    player.sendMessage("You must be OP on the server for execute this command!");
                }
            }
        } else {
            if(command.getName().equalsIgnoreCase("viacheck")){
                if(args.length == 0){
                    commandSender.sendMessage(ChatColor.RED+"Usage: /viacheck <value>");
                } else if(args[0].equalsIgnoreCase("reload")){
                    Main.getInstance().reloadConfig();
                    Main.getInstance().saveConfig();
                    commandSender.sendMessage(ChatColor.GREEN+"The config file has been updated on the server! Try now!");
                }
                }
        }

        return false;
    }
}
