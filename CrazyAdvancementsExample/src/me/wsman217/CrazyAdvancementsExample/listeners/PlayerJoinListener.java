package me.wsman217.CrazyAdvancementsExample.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public class PlayerJoinListener implements Listener {

	public CrazyAdvancementsExample plugin;
	
	public PlayerJoinListener(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		plugin.addPlayers.addToManager(p);
	}
}
