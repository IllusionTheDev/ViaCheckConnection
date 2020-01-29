package fr.x9nico.viacheckconnection.bungee.commands;

import fr.x9nico.viacheckconnection.bungee.Bungee;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ViaCheckCommand extends Command {

    public ViaCheckCommand(String name){
        super(name);
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if(commandSender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer)commandSender;
            if(p.hasPermission("viacheck.use")){
                if(args.length != 1){
                    p.sendMessage(new TextComponent("§cUsage: /viacheck <value>"));
                    return;
                }
                if(args[0].equalsIgnoreCase("reload")){
                    try {
                        Configuration configuration =
                                ConfigurationProvider.getProvider(YamlConfiguration.class)
                                        .load(new File(Bungee.getInstance().getDataFolder(), "config.yml"));
                        ConfigurationProvider.getProvider(YamlConfiguration.class)
                                .save(configuration, new File(Bungee.getInstance().getDataFolder(), "config.yml"));
                        p.sendMessage(new TextComponent("§aReloaded with success!"));
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        } else {
            if(args.length != 1){
                commandSender.sendMessage(new TextComponent(ChatColor.RED+"Usage: /viacheck <value>"));
            } else if(args[0].equalsIgnoreCase("reload")){
                try {
                    Configuration configuration =
                            ConfigurationProvider.getProvider(YamlConfiguration.class)
                                    .load(new File(Bungee.getInstance().getDataFolder(), "config.yml"));
                    ConfigurationProvider.getProvider(YamlConfiguration.class)
                            .save(configuration, new File(Bungee.getInstance().getDataFolder(), "config.yml"));
                    commandSender.sendMessage(new TextComponent(ChatColor.GREEN+"Reloaded with success!"));
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
