package me.wsman217.CrazyAdvancementsExample.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.CrazyAdvancements;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public class PlayerJoinListener implements Listener {

	public CrazyAdvancementsExample plugin;
	
	private static AdvancementManager manager = CrazyAdvancements.getNewAdvancementManager();

	public PlayerJoinListener(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		manager.loadProgress(p,
				CrazyAdvancementsExample.advList.toArray(new Advancement[CrazyAdvancementsExample.advList.size()]));
	}
}
