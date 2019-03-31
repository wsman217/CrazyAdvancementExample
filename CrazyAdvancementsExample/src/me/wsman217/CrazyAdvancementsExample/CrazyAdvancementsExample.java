package me.wsman217.CrazyAdvancementsExample;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.CrazyAdvancements;
import eu.endercentral.crazy_advancements.manager.AdvancementManager;
import me.wsman217.CrazyAdvancementsExample.enums.AdvancementEnum;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerChatListener;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerJoinListener;
import me.wsman217.CrazyAdvancementsExample.tools.AddPlayers;

public class CrazyAdvancementsExample extends JavaPlugin {

	public ArrayList<Advancement> advList = new ArrayList<Advancement>();
	public AdvancementManager manager = CrazyAdvancements.getNewAdvancementManager();
	
	public AddPlayers addPlayers;
	
	@Override
	public void onEnable() {
		
		addPlayers = new AddPlayers(this);
		
		AdvancementEnum.registerAdvancements(this);
		addPlayers();
		registerListeners();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void addPlayers() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			addPlayers.addToManager(p);
		}
	}
	
	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChatListener(this), this);
	}
}
