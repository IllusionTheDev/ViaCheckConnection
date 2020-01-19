package fr.x9nico.viacheckconnection;

import fr.x9nico.viacheckconnection.commands.ViaCheckReloadCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

public class Main extends JavaPlugin implements Listener {

    static Main instance;
    FileConfiguration config;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getLogger().info("You are using the plugin on a Spigot server");
        getLogger().info("Plugin version: " + getDescription().getVersion());
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        getCommand("viacheck").setExecutor(new ViaCheckReloadCommand());
        instance = this;
        boolean isUpdate = Updater.checkForUpdate(this, 31805, false);
        if (isUpdate) {
            getLogger().info("We found a plugin update! Downloading it...");
            boolean success = Updater.download(this, 31805);
            if (success) {
                getLogger().info("The plugin has been updated, please restart the server.");
            } else {
                getLogger().info("The plugin couldn't be updated. Either Spiget is down or you're using a dev version.");
            }
        }
        if (Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.11") || Bukkit.getVersion().contains("1.10") || Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.13") || Bukkit.getVersion().contains("1.14")) {
            getServer().getPluginManager().enablePlugin(this);
        }
        new Metrics(this);
    }

    @SuppressWarnings("unchecked")
    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (Bukkit.getVersion().contains("1.8")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()) {
                p.sendMessage(getConfig().getString("v1_8").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()) {
                p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()) {
                p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()) {
                p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()) {
                p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()) {
                p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()) {
                p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()) {
                p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("v1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.9")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()) {
                p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()) {
                p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()) {
                p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()) {
                p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()) {
                p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()) {
                p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()) {
                p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.10")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()) {
                p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()) {
                p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()) {
                p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("v1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.11")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()) {
                p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()) {
                p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("v1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.12")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("v1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.13")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if (Bukkit.getVersion().contains("1.14")) {
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            }
        } else if(Bukkit.getVersion().contains("1.15")){
            if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()) {
                p.sendMessage(getConfig().getString("v1_14_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()) {
                p.sendMessage(getConfig().getString("v1_14_2").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
                p.sendMessage(getConfig().getString("v1_14_3").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
                p.sendMessage(getConfig().getString("v1_14_4").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
                p.sendMessage(getConfig().getString("v1_15").replace("&", "§"));
            }  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
                p.sendMessage(getConfig().getString("v1_15_1").replace("&", "§"));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
                p.sendMessage(getConfig().getString("v1_15_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()) {
                p.sendMessage(getConfig().getString("v1_8").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()) {
                p.sendMessage(getConfig().getString("v1_9_0").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()) {
                p.sendMessage(getConfig().getString("v1_9_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()) {
                p.sendMessage(getConfig().getString("v1_9_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()) {
                p.sendMessage(getConfig().getString("v1_9_3").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()) {
                p.sendMessage(getConfig().getString("v1_10").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()) {
                p.sendMessage(getConfig().getString("v1_11").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()) {
                p.sendMessage(getConfig().getString("v1_11_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()) {
                p.sendMessage(getConfig().getString("v1_12").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()) {
                p.sendMessage(getConfig().getString("unknown_version").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()) {
                p.sendMessage(getConfig().getString("v1_7_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()) {
                p.sendMessage(getConfig().getString("v1_7_6").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
                p.sendMessage(getConfig().getString("v1_12_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
                p.sendMessage(getConfig().getString("v1_12_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
                p.sendMessage(getConfig().getString("v1_13").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()) {
                p.sendMessage(getConfig().getString("v1_13_1").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()) {
                p.sendMessage(getConfig().getString("v1_13_2").replace("&", "§"));
            } else if (Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()) {
                p.sendMessage(getConfig().getString("v1_14").replace("&", "§"));
            }
        }
    }
}
