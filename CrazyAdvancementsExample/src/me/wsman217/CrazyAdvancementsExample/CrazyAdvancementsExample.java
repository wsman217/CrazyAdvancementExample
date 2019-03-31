package me.wsman217.CrazyAdvancementsExample;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import eu.endercentral.crazy_advancements.Advancement;
import me.wsman217.CrazyAdvancementsExample.enums.AdvancementEnum;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerChatListener;
import me.wsman217.CrazyAdvancementsExample.listeners.PlayerJoinListener;

public class CrazyAdvancementsExample extends JavaPlugin {

	public static ArrayList<Advancement> advList = new ArrayList<Advancement>();
	
	@Override
	public void onEnable() {
		AdvancementEnum.registerAdvancements();
		registerListeners();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerChatListener(this), this);
	}
	
	public static void addAdvList(Advancement adv) {
		advList.add(adv);
	}
}
