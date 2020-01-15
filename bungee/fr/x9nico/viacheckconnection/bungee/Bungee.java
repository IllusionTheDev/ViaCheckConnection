package fr.x9nico.viacheckconnection.bungee;

import com.google.common.io.ByteStreams;
import fr.x9nico.viacheckconnection.bungee.commands.ViaCheckCommand;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;
import us.myles.ViaVersion.api.Via;
import us.myles.ViaVersion.api.protocol.ProtocolVersion;

import java.io.*;

public class Bungee extends Plugin implements Listener{
	
	static Bungee instance;
	
	@Override
	public void onEnable() {
		getLogger().info("You are using the plugin on a BungeeCord proxy. Don't forget to remove it from your Spigot servers.");
		getLogger().info("Plugin version: "+getDescription().getVersion());
		getProxy().getPluginManager().registerListener(this, this);
		getProxy().getPluginManager().registerCommand(this, new ViaCheckCommand("viacheck"));
		instance = this;
		new Metrics(this);
		/*boolean isUpdate = BungeeUpdater.checkForUpdate(this, 31805, false);
		if(isUpdate){
			getLogger().info("[ViaCheckConnection] Update available ! updating...");
		boolean success = BungeeUpdater.download(this, 31805);
		if(success){
			getLogger().info("[ViaCheckConnection] The plugin has been updated.Please restart your server");
		} else {
			getLogger().info("[ViaCheckConnection] Error for update the plugin, maybe spiget or spigot down ?");
			getLogger().info("[ViaCheckConnection] Or maybe you are running a dev-version ?");
		}
		}*/
		//Creates config.
				if (!getDataFolder().exists()) {
		            getDataFolder().mkdir();
		        }
		        File configFile = new File(getDataFolder(), "config.yml");
		        if (!configFile.exists()) {
		            try {
		                configFile.createNewFile();
		                try (InputStream is = getResourceAsStream("config.yml");
		                     OutputStream os = new FileOutputStream(configFile)) {
		                    ByteStreams.copy(is, os);
		                }
		            } catch (IOException e) {
		                throw new RuntimeException("Unable to create configuration file.", e);
		            }
		        }
		        
		        //Loads config.
		        try {
					ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
				} catch (IOException e2) {
					throw new RuntimeException("Unable to load configuration file.", e2);
				}
	}
	
	@SuppressWarnings({ "unchecked" })
	@EventHandler
	public void join(ServerConnectedEvent e) throws IOException{
		ProxiedPlayer p = e.getPlayer();
		Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
		if(Bungee.isProtocolSupport()){
			if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_8").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_3").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_10").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_11").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_11_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_12").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
				p.sendMessage(new TextComponent(config.getString("unknown_version").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_7_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_7_6.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_7_6").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_12_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_12_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_13").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()){
                p.sendMessage(new TextComponent(config.getString("v1_13_1").replace("&", "§")));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_13_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_3").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_4").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15_2").replace("&", "§")));
			}
		} else {
			if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_8.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_8").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_9_3.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_9_3").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_10.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_10").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_11").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_11_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_11_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_12").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.unknown.getId()){
				p.sendMessage(new TextComponent(config.getString("unknown_version").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_1.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_12_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_12_2.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_12_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13.getId()) {
				p.sendMessage(new TextComponent(config.getString("v1_13").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_1.getId()){
                p.sendMessage(new TextComponent(config.getString("v1_13_1").replace("&", "§")));
            } else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_13_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_13_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14").replace("&", "§")));
			}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_1").replace("&", "§")));
			}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_2").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_3.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_3").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_14_4.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_14_4").replace("&", "§")));
			}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15").replace("&", "§")));
			}  else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_1.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15_1").replace("&", "§")));
			} else if(Via.getAPI().getPlayerVersion(p) == ProtocolVersion.v1_15_2.getId()){
				p.sendMessage(new TextComponent(config.getString("v1_15_2").replace("&", "§")));
			}
		}
	}
	
	public static boolean isProtocolSupport(){
		return true;
	}
	
	public static Bungee getInstance() {
		return instance;
	}

}
