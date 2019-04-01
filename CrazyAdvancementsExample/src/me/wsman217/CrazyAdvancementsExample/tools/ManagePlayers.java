package me.wsman217.CrazyAdvancementsExample.tools;

import org.bukkit.entity.Player;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public class ManagePlayers {

	public CrazyAdvancementsExample plugin;
	public AdvancementManager manager;

	public ManagePlayers(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
		this.manager = plugin.manager;
	}

	public void addToManager() {
		for (Player p : plugin.getServer().getOnlinePlayers()) {
			manager.loadProgress(p, plugin.advList.toArray(new Advancement[plugin.advList.size()]));
			manager.addPlayer(p);
		}
		System.out.println(manager.getPlayers());
	}
	
	public void removeFromManager(Player p) {
		manager.removePlayer(p);
		System.out.println(manager.getPlayers());
	}
}
