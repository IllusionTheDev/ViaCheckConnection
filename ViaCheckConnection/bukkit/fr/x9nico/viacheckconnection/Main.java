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
        if (Bukkit.getVersion().contains("1.15") || Bukkit.getVersion().contains("1.16") || Bukkit.getVersion().contains("1.12") || Bukkit.getVersion().contains("1.11") || Bukkit.getVersion().contains("1.10") || Bukkit.getVersion().contains("1.9") || Bukkit.getVersion().contains("1.13") || Bukkit.getVersion().contains("1.14")) {
            getServer().getPluginManager().enablePlugin(this);
        }
        new Metrics(this);
    }

    @SuppressWarnings("unchecked")
    @EventHandler
    public void join(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(getConfig().getString(ProtocolVersion.getProtocol(Via.getAPI().getPlayerVersion(p)).getName()));
    }
}
