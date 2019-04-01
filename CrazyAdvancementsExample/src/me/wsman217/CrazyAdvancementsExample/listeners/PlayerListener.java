package me.wsman217.CrazyAdvancementsExample.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public class PlayerListener implements Listener {

	public CrazyAdvancementsExample plugin;
	
	public PlayerListener(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		//Player p = event.getPlayer();
		plugin.managePlayers.addToManager();
	}
	
	@EventHandler
	public void onPlayerLeaveEvent(PlayerQuitEvent event) {
		plugin.managePlayers.removeFromManager(event.getPlayer());
	}
}
