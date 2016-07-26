package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class EnchantBookLores implements Listener {
	private static ArrayList<String> soulBookItemLores = new ArrayList<String>();
	private static ArrayList<String> legendaryBookItemLores = new ArrayList<String>();
	private static ArrayList<String> ultimateBookItemLores = new ArrayList<String>();
	private static ArrayList<String> eliteBookItemLores = new ArrayList<String>();
	private static ArrayList<String> uniqueBookItemLores = new ArrayList<String>();
	private static ArrayList<String> simpleBookItemLores = new ArrayList<String>();
	
	
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		String soulBookItemLores = null;
		String legendaryBookItemLores = null;
		String ultimateBookItemLores = null;
		String eliteBookItemLores = null;
		String uniqueBookItemLores = null;
		String simpleBookItemLores = null;
		
		for(int i = 1; i <= 3; i++) {
			if(i == 1) { soulBookItemLores = "DivineImmolation"; 
			} else if(i == 2) { soulBookItemLores = "Immortal";
			} else if(i == 3) { soulBookItemLores = "NaturesWrath"; }
			for(int o = 1; o <= 5; o++) {
				if(!(soulBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore") == null)
						&& !(soulBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.soulBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Soul." + soulBookItemLores) == true) {
					EnchantBookLores.soulBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookItemLores + "." + soulBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 18; i++) {
			if(i == 1) {
				legendaryBookItemLores = "Barbarian";
			} else if(i == 2) {
				legendaryBookItemLores = "BloodLust";
			} else if(i == 3) {
				legendaryBookItemLores = "Clarity";
			} else if(i == 4) {
				legendaryBookItemLores = "Deathbringer";
			} else if(i == 5) {
				legendaryBookItemLores = "Devour";
			} else if(i == 6) {
				legendaryBookItemLores = "Disarmor";
			} else if(i == 7) {
				legendaryBookItemLores = "Drunk";
			} else if(i == 8) {
				legendaryBookItemLores = "Enlighted";
			} else if(i == 9) {
				legendaryBookItemLores = "Gears";
			} else if(i == 10) {
				legendaryBookItemLores = "Ghost";
			} else if(i == 11) {
				legendaryBookItemLores = "Greatsword";
			} else if(i == 12) {
				legendaryBookItemLores = "Inquisitive";
			} else if(i == 13) {
				legendaryBookItemLores = "KillAura";
			} else if(i == 14) {
				legendaryBookItemLores = "Lifesteal";
			} else if(i == 15) {
				legendaryBookItemLores = "Overload";
			} else if(i == 16) {
				legendaryBookItemLores = "Protection";
			} else if(i == 17) {
				legendaryBookItemLores = "Rage";
			} else if(i == 18) {
				legendaryBookItemLores = "Sniper";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(legendaryBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore") == null)
						&& !(legendaryBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.legendaryBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Legendary." + legendaryBookItemLores) == true) {
					EnchantBookLores.legendaryBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookItemLores + "." + legendaryBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 25; i++) {
			if(i == 1) {
				ultimateBookItemLores = "Angelic";
			} else if(i == 2) {
				ultimateBookItemLores = "Armored";
			} else if(i == 3) {
				ultimateBookItemLores = "ArrowLifesteal";
			} else if(i == 4) {
				ultimateBookItemLores = "Bleed";
			} else if(i == 5) {
				ultimateBookItemLores = "Blessed";
			} else if(i == 6) {
				ultimateBookItemLores = "Blind";
			} else if(i == 7) {
				ultimateBookItemLores = "Block";
			} else if(i == 8) {
				ultimateBookItemLores = "Cleave";
			} else if(i == 9) {
				ultimateBookItemLores = "CreeperArmor";
			} else if(i == 10) {
				ultimateBookItemLores = "Demonforged";
			} else if(i == 11) {
				ultimateBookItemLores = "Detonate";
			} else if(i == 12) {
				ultimateBookItemLores = "Guardians";
			} else if(i == 13) {
				ultimateBookItemLores = "Hardened";
			} else if(i == 14) {
				ultimateBookItemLores = "Leadership";
			} else if(i == 15) {
				ultimateBookItemLores = "Lucky";
			} else if(i == 16) {
				ultimateBookItemLores = "ObsidianShield";
			} else if(i == 17) {
				ultimateBookItemLores = "Piercing";
			} else if(i == 18) {
				ultimateBookItemLores = "Shackle";
			} else if(i == 19) {
				ultimateBookItemLores = "Silence";
			} else if(i == 20) {
				ultimateBookItemLores = "Skilling";
 			} else if(i == 21) {
 				ultimateBookItemLores = "Tank";
 			} else if(i == 22) {
 				ultimateBookItemLores = "Training";
 			} else if(i == 23) {
 				ultimateBookItemLores = "Unfocus";
			} else if(i == 24) {
				ultimateBookItemLores = "Venom";
			} else if(i == 25) {
				ultimateBookItemLores = "Wither";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(ultimateBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore") == null)
						&& !(ultimateBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.ultimateBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Ultimate." + ultimateBookItemLores) == true) {
					EnchantBookLores.ultimateBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookItemLores + "." + ultimateBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 30; i++) {
			if(i == 1) {
				eliteBookItemLores = "AntiGravity";
			} else if(i == 2) {
				eliteBookItemLores = "Cactus";
			} else if(i == 3) {
				eliteBookItemLores = "DeepWounds";
			} else if(i == 4) {
				eliteBookItemLores = "DoubleStrike";
			} else if(i == 5) {
				eliteBookItemLores = "EnderWalker";
			} else if(i == 6) {
				eliteBookItemLores = "Execute";
			} else if(i == 7) {
				eliteBookItemLores = "Frozen";
			} else if(i == 8) {
				eliteBookItemLores = "Hellfire";
			} else if(i == 9) {
				eliteBookItemLores = "IceAspect";
			} else if(i == 10) {
				eliteBookItemLores = "IceFreeze";
			} else if(i == 11) {
				eliteBookItemLores = "Implants";
			} else if(i == 12) {
				eliteBookItemLores = "Infernal";
			} else if(i == 13) {
				eliteBookItemLores = "Nimble";
			} else if(i == 14) {
				eliteBookItemLores = "Poison";
			} else if(i == 15) {
				eliteBookItemLores = "Poisoned";
			} else if(i == 16) {
				eliteBookItemLores = "Pummel";
			} else if(i == 17) {
				eliteBookItemLores = "RocketEscape";
			} else if(i == 18) {
				eliteBookItemLores = "Shockwave";
			} else if(i == 19) {
				eliteBookItemLores = "SkillSwipe";
			} else if(i == 20) {
				eliteBookItemLores = "SmokeBomb";
 			} else if(i == 21) {
 				eliteBookItemLores = "Spirits";
			} else if(i == 22) {
				eliteBookItemLores = "Springs";
			} else if(i == 23) {
				eliteBookItemLores = "Telepathy";
			} else if(i == 24) {
				eliteBookItemLores = "Teleportation";
			} else if(i == 25) {
				eliteBookItemLores = "Trap";
			} else if(i == 26) {
				eliteBookItemLores = "UndeadRuse";
			} else if(i == 27) {
				eliteBookItemLores = "Valor";
			} else if(i == 28) {
				eliteBookItemLores = "Vampire";
			} else if(i == 29) {
				eliteBookItemLores = "Virus";
			} else if(i == 30) {
				eliteBookItemLores = "Voodoo";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(eliteBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore") == null)
						&& !(eliteBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.eliteBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Elite." + eliteBookItemLores) == true) {
					EnchantBookLores.eliteBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookItemLores + "." + eliteBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 19; i++) {
			if(i == 1) {
				uniqueBookItemLores = "Aquatic";
			} else if(i == 2) {
				uniqueBookItemLores = "AutoSmelt";
			} else if(i == 3) {
				uniqueBookItemLores = "Commander";
			} else if(i == 4) {
				uniqueBookItemLores = "Cowification";
			} else if(i == 5) {
				uniqueBookItemLores = "Curse";
			} else if(i == 6) {
				uniqueBookItemLores = "EnderShift";
			} else if(i == 7) {
				uniqueBookItemLores = "Experience";
			} else if(i == 8) {
				uniqueBookItemLores = "Explosive";
			} else if(i == 9) {
				uniqueBookItemLores = "Featherweight";
			} else if(i == 10) {
				uniqueBookItemLores = "Molten";
			} else if(i == 11) {
				uniqueBookItemLores = "ObsidianDestroyer";
			} else if(i == 12) {
				uniqueBookItemLores = "Paralyze";
			} else if(i == 13) {
				uniqueBookItemLores = "PlagueCarrier";
			} else if(i == 14) {
				uniqueBookItemLores = "Ragdoll";
			} else if(i == 15) {
				uniqueBookItemLores = "Ravenous";
			} else if(i == 16) {
				uniqueBookItemLores = "Reforged";
			} else if(i == 17) {
				uniqueBookItemLores = "SelfDestruct";
			} else if(i == 18) {
				uniqueBookItemLores = "SpiritLink";
			} else if(i == 19) {
				uniqueBookItemLores = "Stormcaller";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(uniqueBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore") == null)
						&& !(uniqueBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.uniqueBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Unique." + uniqueBookItemLores) == true) {
					EnchantBookLores.uniqueBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookItemLores + "." + uniqueBookItemLores + o + ".ItemLore")));
				}
			}
		}
		for(int i = 1; i <= 13; i++) {
			if(i == 1) {
				simpleBookItemLores = "Confusion";
			} else if(i == 2) {
				simpleBookItemLores = "Decapitation";
			} else if(i == 3) {
				simpleBookItemLores = "Epicness";
			} else if(i == 4) {
				simpleBookItemLores = "Glowing";
			} else if(i == 5) {
				simpleBookItemLores = "Haste";
			} else if(i == 6) {
				simpleBookItemLores = "Headless";
			} else if(i == 7) {
				simpleBookItemLores = "Healing";
			} else if(i == 8) {
				simpleBookItemLores = "Insomnia";
			} else if(i == 9) {
				simpleBookItemLores = "Lightning";
			} else if(i == 10) {
				simpleBookItemLores = "Nutrition";
			} else if(i == 11) {
				simpleBookItemLores = "Obliterate";
			} else if(i == 12) {
				simpleBookItemLores = "Oxygenate";
			} else if(i == 13) {
				simpleBookItemLores = "ThunderingBlow";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(simpleBookItemLores == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore") == null)
						&& !(simpleBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore") == null)
						&& !(EnchantBookLores.simpleBookItemLores.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore"))))
						&& RandomPackage.getEnabledEnchantsConfig().getBoolean("Simple." + simpleBookItemLores) == true) {
					EnchantBookLores.simpleBookItemLores.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookItemLores + "." + simpleBookItemLores + o + ".ItemLore")));
				}
			}
		}
		return;
	}
	public static ArrayList<String> getSoulItemLores() { return soulBookItemLores; }
	public static ArrayList<String> getLegendaryItemLores() { return legendaryBookItemLores; }
	public static ArrayList<String> getUltimateItemLores() { return ultimateBookItemLores; }
	public static ArrayList<String> getEliteItemLores() { return eliteBookItemLores; }
	public static ArrayList<String> getUniqueItemLores() { return uniqueBookItemLores; }
	public static ArrayList<String> getSimpleItemLores() { return simpleBookItemLores; }
}
