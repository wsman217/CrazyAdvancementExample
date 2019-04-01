package me.wsman217.CrazyAdvancementsExample.enums;

import java.util.ArrayList;

import org.bukkit.Material;

import eu.endercentral.crazy_advancements.Advancement;
import eu.endercentral.crazy_advancements.AdvancementDisplay;
import eu.endercentral.crazy_advancements.AdvancementDisplay.AdvancementFrame;
import eu.endercentral.crazy_advancements.AdvancementVisibility;
import eu.endercentral.crazy_advancements.NameKey;
import me.wsman217.CrazyAdvancementsExample.CrazyAdvancementsExample;

public enum AdvancementEnum {

	ROOT(Material.ARMOR_STAND, 2, "Root Advancement", "Chat for the first time!", AdvancementFrame.TASK,
			"textures/blocks/concrete_yellow.png", true, true, AdvancementVisibility.ALWAYS),
	CRAFT(AdvancementEnum.ROOT, Material.CRAFTING_TABLE, 2, "Crafty", "Craft something!", AdvancementFrame.TASK, 1, 2, true,
			true, AdvancementVisibility.ALWAYS);

	private Advancement advancement;
	private AdvancementEnum parent;
	private final Material icon;
	private final int required;
	private String title, description;
	private final AdvancementDisplay.AdvancementFrame frame;
	private String backgroundTexture;
	private float x, y;
	private final boolean showToast, announceChat;
	private final AdvancementVisibility visibility;

	private AdvancementEnum(Material icon, int required, String title, String description, AdvancementFrame frame,
			String backgroundTexture, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.parent = null;
		this.icon = icon;
		this.required = required;
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.backgroundTexture = backgroundTexture;
		this.showToast = showToast;
		this.announceChat = announceChat;
		this.visibility = visibility;
	}

	private AdvancementEnum(AdvancementEnum parent, Material icon, int required, String title, String description,
			AdvancementFrame frame, float x, float y, boolean showToast, boolean announceChat,
			AdvancementVisibility visibility) {
		this.parent = parent;
		this.icon = icon;
		this.required = required;
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.x = x;
		this.y = y;
		this.showToast = showToast;
		this.announceChat = announceChat;
		this.visibility = visibility;
	}

	public Advancement getAdvancement() {
		return this.advancement;
	}

	public AdvancementEnum getParent() {
		return this.parent;
	}

	public Material getIcon() {
		return this.icon;
	}

	public int getRequired() {
		return this.required;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public AdvancementFrame getFrame() {
		return this.frame;
	}

	public String getBackground() {
		return this.backgroundTexture;
	}

	public float getX() {
		return this.x;
	}

	public float getY() {
		return this.y;
	}

	public boolean getToast() {
		return this.showToast;
	}

	public boolean getAnnounce() {
		return this.announceChat;
	}

	public AdvancementVisibility getVisibility() {
		return this.visibility;
	}

	public static void registerAdvancements(CrazyAdvancementsExample plugin) {
		ArrayList<Advancement> advList = new ArrayList<Advancement>();
		for (AdvancementEnum adv : AdvancementEnum.values()) {

			AdvancementDisplay display = new AdvancementDisplay(adv.getIcon(), adv.getTitle(), adv.getDescription(),
					adv.getFrame(), adv.getToast(), adv.getAnnounce(), adv.getVisibility());

			if (adv.getParent() == null)
				display.setBackgroundTexture(adv.getBackground());
			else
				display.setCoordinates(adv.getX(), adv.getY());

			adv.advancement = new Advancement(adv.getParent() == null ? null : adv.getParent().getAdvancement(),
					new NameKey("CrazyAdvancementsExample", adv.name().toLowerCase()), display);
			adv.advancement.setCriteria(adv.getRequired());
			advList.add(adv.getAdvancement());
			plugin.advList.add(adv.getAdvancement());
		}

		plugin.manager.addAdvancement(advList.toArray(new Advancement[advList.size()]));
		System.out.println(plugin.manager.getAdvancements());
	}
}
