package me.wsman217.CrazyAdvancementsExample.tools;

import org.bukkit.entity.Player;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public class AddPlayers {

	public CrazyAdvancementsExample plugin;
	public AdvancementManager manager;

	public AddPlayers(CrazyAdvancementsExample plugin) {
		this.plugin = plugin;
		this.manager = plugin.manager;
	}

	public void addToManager(Player p) {
		manager.loadProgress(p, plugin.advList.toArray(new Advancement[plugin.advList.size()]));
		manager.addPlayer(p);
	}
}
