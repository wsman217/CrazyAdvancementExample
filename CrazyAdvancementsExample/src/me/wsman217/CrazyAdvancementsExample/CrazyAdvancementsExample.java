package me.wsman217.CrazyAdvancementsExample;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.CrazyAdvancements;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.enums.AdvancementEnum;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerChatListener;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerListener;
import me.wsman217.CrazyAdvancementsExample.tools.ManagePlayers;

public class CrazyAdvancementsExample extends JavaPlugin {

	public ArrayList<Advancement> advList = new ArrayList<Advancement>();
	public AdvancementManager manager = CrazyAdvancements.getNewAdvancementManager();

	public ManagePlayers managePlayers;

	@Override
	public void onEnable() {

		managePlayers = new ManagePlayers(this);

		AdvancementEnum.registerAdvancements(this);
		System.out.println(manager.getPlayers());
		addPlayers();
		registerListeners();
	}

	@Override
	public void onDisable() {

	}

	public void addPlayers() {
		managePlayers.addToManager();
	}

	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChatListener(this), this);
	}
}
