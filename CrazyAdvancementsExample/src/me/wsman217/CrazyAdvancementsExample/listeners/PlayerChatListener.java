package me.wsman217.CrazyAdvancementsExample.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.CrazyAdvancements;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;
import me.wsman217.CrazyAdvancementsExample.enums.AdvancementEnum;

public class PlayerChatListener implements Listener {

	public CrazyAdvancementsExample plugin;
	private static AdvancementManager manager = CrazyAdvancements.getNewAdvancementManager();

	
	public PlayerChatListener(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		
		Advancement adv = AdvancementEnum.ROOT.getAdvancement();
		
		if (manager.getCriteriaProgress(p, adv) < adv.getCriteria()) {
			manager.setCriteriaProgress(p, adv, manager.getCriteriaProgress(p, adv) + 1);
			System.out.println("REEEEEEEEEEEE");
			manager.update(p);
			return;
		}
		System.out.println("Granted");
		manager.grantAdvancement(p, adv);
	}
}
