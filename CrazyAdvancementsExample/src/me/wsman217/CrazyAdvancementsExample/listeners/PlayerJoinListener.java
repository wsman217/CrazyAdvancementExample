package me.wsman217.CrazyAdvancementsExample.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import eu.endercentral.crazy_advancements.Advancement;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;
import me.wsman217.CrazyAdvancementsExample.enums.AdvancementEnum;

public class PlayerJoinListener implements Listener {

	public CrazyAdvancementsExample plugin;
	
	public PlayerJoinListener(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		AdvancementEnum.manager.loadProgress(p,
				CrazyAdvancementsExample.advList.toArray(new Advancement[CrazyAdvancementsExample.advList.size()]));
		System.out.println("test");
		AdvancementEnum.manager.addPlayer(p);
	}
}
