package me.randomHashTags.randomPackage.RandomArmorEffects.Books;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import me.randomHashTags.randomPackage.Core.RandomPackage;

public class EnchantBookNames implements Listener {
	private static ArrayList<String> soulBookNames = new ArrayList<String>();
	private static ArrayList<String> legendaryBookNames = new ArrayList<String>();
	private static ArrayList<String> ultimateBookNames = new ArrayList<String>();
	private static ArrayList<String> eliteBookNames = new ArrayList<String>();
	private static ArrayList<String> uniqueBookNames = new ArrayList<String>();
	private static ArrayList<String> simpleBookNames = new ArrayList<String>();
	
	@EventHandler
	private void pluginEnableEvent(PluginEnableEvent event) {
		String soulBookNames = null, legendaryBookNames = null, ultimateBookNames = null, eliteBookNames = null, uniqueBookNames = null, simpleBookNames = null;
		
		for(int i = 1; i <= 3; i++) {
			if(i == 1) { soulBookNames = "DivineImmolation"; 
			} else if(i == 2) { soulBookNames = "Immortal";
			} else if(i == 3) {	soulBookNames = "NaturesWrath";
			} else { return;
			}
			for(int o = 1; o <= 4; o++) {
				if(!(soulBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookNames + "." + soulBookNames + o + ".BookName") == null)
						&& !(soulBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookNames + "." + soulBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookNames + "." + soulBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.soulBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookNames + "." + soulBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Soul." + soulBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.soulBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Soul." + soulBookNames + "." + soulBookNames + o + ".BookName")));
				}
			}
		}
		for(int i = 1; i <= 18; i++) {
			if(i == 1) {
				legendaryBookNames = "Barbarian";
			} else if(i == 2) {
				legendaryBookNames = "BloodLust";
			} else if(i == 3) {
				legendaryBookNames = "Clarity";
			} else if(i == 4) {
				legendaryBookNames = "Deathbringer";
			} else if(i == 5) {
				legendaryBookNames = "Devour";
			} else if(i == 6) {
				legendaryBookNames = "Disarmor";
			} else if(i == 7) {
				legendaryBookNames = "Drunk";
			} else if(i == 8) {
				legendaryBookNames = "Enlighted";
			} else if(i == 9) {
				legendaryBookNames = "Gears";
			} else if(i == 10) {
				legendaryBookNames = "Ghost";
			} else if(i == 11) {
				legendaryBookNames = "Greatsword";
			} else if(i == 12) {
				legendaryBookNames = "Inquisitive";
			} else if(i == 13) {
				legendaryBookNames = "KillAura";
			} else if(i == 14) {
				legendaryBookNames = "Lifesteal";
			} else if(i == 15) {
				legendaryBookNames = "Overload";
			} else if(i == 16) {
				legendaryBookNames = "Protection";
			} else if(i == 17) {
				legendaryBookNames = "Rage";
			} else if(i == 18) {
				legendaryBookNames = "Sniper";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(legendaryBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookNames + "." + legendaryBookNames + o + ".BookName") == null)
						&& !(legendaryBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookNames + "." + legendaryBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookNames + "." + legendaryBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.legendaryBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookNames + "." + legendaryBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Legendary." + legendaryBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.legendaryBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Legendary." + legendaryBookNames + "." + legendaryBookNames + o + ".BookName")));
				}
			}
		}
		for(int i = 1; i <= 25; i++) {
			if(i == 1) {
				ultimateBookNames = "Angelic";
			} else if(i == 2) {
				ultimateBookNames = "Armored";
			} else if(i == 3) {
				ultimateBookNames = "ArrowLifesteal";
			} else if(i == 4) {
				ultimateBookNames = "Bleed";
			} else if(i == 5) {
				ultimateBookNames = "Blessed";
			} else if(i == 6) {
				ultimateBookNames = "Blind";
			} else if(i == 7) {
				ultimateBookNames = "Block";
			} else if(i == 8) {
				ultimateBookNames = "Cleave";
			} else if(i == 9) {
				ultimateBookNames = "CreeperArmor";
			} else if(i == 10) {
				ultimateBookNames = "Demonforged";
			} else if(i == 11) {
				ultimateBookNames = "Detonate";
			} else if(i == 12) {
				ultimateBookNames = "Guardians";
			} else if(i == 13) {
				ultimateBookNames = "Hardened";
			} else if(i == 14) {
				ultimateBookNames = "Leadership";
			} else if(i == 15) {
				ultimateBookNames = "Lucky";
			} else if(i == 16) {
				ultimateBookNames = "ObsidianShield";
			} else if(i == 17) {
				ultimateBookNames = "Piercing";
			} else if(i == 18) {
				ultimateBookNames = "Shackle";
			} else if(i == 19) {
				ultimateBookNames = "Silence";
			} else if(i == 20) {
				ultimateBookNames = "Skilling";
 			} else if(i == 21) {
 				ultimateBookNames = "Tank";
 			} else if(i == 22) {
 				ultimateBookNames = "Training";
 			} else if(i == 23) {
 				ultimateBookNames = "Unfocus";
			} else if(i == 24) {
				ultimateBookNames = "Venom";
			} else if(i == 25) {
				ultimateBookNames = "Wither";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(ultimateBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookNames + "." + ultimateBookNames + o + ".BookName") == null)
						&& !(ultimateBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookNames + "." + ultimateBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookNames + "." + ultimateBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.ultimateBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookNames + "." + ultimateBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Ultimate." + ultimateBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.ultimateBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Ultimate." + ultimateBookNames + "." + ultimateBookNames + o + ".BookName")));
				}
			}
		}
		for(int i = 1; i <= 30; i++) {
			if(i == 1) {
				eliteBookNames = "AntiGravity";
			} else if(i == 2) {
				eliteBookNames = "Cactus";
			} else if(i == 3) {
				eliteBookNames = "DeepWounds";
			} else if(i == 4) {
				eliteBookNames = "DoubleStrike";
			} else if(i == 5) {
				eliteBookNames = "EnderWalker";
			} else if(i == 6) {
				eliteBookNames = "Execute";
			} else if(i == 7) {
				eliteBookNames = "Frozen";
			} else if(i == 8) {
				eliteBookNames = "Hellfire";
			} else if(i == 9) {
				eliteBookNames = "IceAspect";
			} else if(i == 10) {
				eliteBookNames = "IceFreeze";
			} else if(i == 11) {
				eliteBookNames = "Implants";
			} else if(i == 12) {
				eliteBookNames = "Infernal";
			} else if(i == 13) {
				eliteBookNames = "Nimble";
			} else if(i == 14) {
				eliteBookNames = "Poison";
			} else if(i == 15) {
				eliteBookNames = "Poisoned";
			} else if(i == 16) {
				eliteBookNames = "Pummel";
			} else if(i == 17) {
				eliteBookNames = "RocketEscape";
			} else if(i == 18) {
				eliteBookNames = "Shockwave";
			} else if(i == 19) {
				eliteBookNames = "SkillSwipe";
			} else if(i == 20) {
				eliteBookNames = "SmokeBomb";
 			} else if(i == 21) {
 				eliteBookNames = "Spirits";
			} else if(i == 22) {
				eliteBookNames = "Springs";
			} else if(i == 23) {
				eliteBookNames = "Telepathy";
			} else if(i == 24) {
				eliteBookNames = "Teleportation";
			} else if(i == 25) {
				eliteBookNames = "Trap";
			} else if(i == 26) {
				eliteBookNames = "UndeadRuse";
			} else if(i == 27) {
				eliteBookNames = "Valor";
			} else if(i == 28) {
				eliteBookNames = "Vampire";
			} else if(i == 29) {
				eliteBookNames = "Virus";
			} else if(i == 30) {
				eliteBookNames = "Voodoo";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(eliteBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookNames + "." + eliteBookNames + o + ".BookName") == null)
						&& !(eliteBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookNames + "." + eliteBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookNames + "." + eliteBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.eliteBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookNames + "." + eliteBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Elite." + eliteBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.eliteBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Elite." + eliteBookNames + "." + eliteBookNames + o + ".BookName")));
				}
			}
		}
		for(int i = 1; i <= 19; i++) {
			if(i == 1) {
				uniqueBookNames = "Aquatic";
			} else if(i == 2) {
				uniqueBookNames = "AutoSmelt";
			} else if(i == 3) {
				uniqueBookNames = "Commander";
			} else if(i == 4) {
				uniqueBookNames = "Cowification";
			} else if(i == 5) {
				uniqueBookNames = "Curse";
			} else if(i == 6) {
				uniqueBookNames = "EnderShift";
			} else if(i == 7) {
				uniqueBookNames = "Experience";
			} else if(i == 8) {
				uniqueBookNames = "Explosive";
			} else if(i == 9) {
				uniqueBookNames = "Featherweight";
			} else if(i == 10) {
				uniqueBookNames = "Molten";
			} else if(i == 11) {
				uniqueBookNames = "ObsidianDestroyer";
			} else if(i == 12) {
				uniqueBookNames = "Paralyze";
			} else if(i == 13) {
				uniqueBookNames = "PlagueCarrier";
			} else if(i == 14) {
				uniqueBookNames = "Ragdoll";
			} else if(i == 15) {
				uniqueBookNames = "Ravenous";
			} else if(i == 16) {
				uniqueBookNames = "Reforged";
			} else if(i == 17) {
				uniqueBookNames = "SelfDestruct";
			} else if(i == 18) {
				uniqueBookNames = "SpiritLink";
			} else if(i == 19) {
				uniqueBookNames = "Stormcaller";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(uniqueBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookNames + "." + uniqueBookNames + o + ".BookName") == null)
						&& !(uniqueBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookNames + "." + uniqueBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookNames + "." + uniqueBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.uniqueBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookNames + "." + uniqueBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Unique." + uniqueBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.uniqueBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Unique." + uniqueBookNames + "." + uniqueBookNames + o + ".BookName")));
				}
			}
		}
		for(int i = 1; i <= 13; i++) {
			if(i == 1) {
				simpleBookNames = "Confusion";
			} else if(i == 2) {
				simpleBookNames = "Decapitation";
			} else if(i == 3) {
				simpleBookNames = "Epicness";
			} else if(i == 4) {
				simpleBookNames = "Glowing";
			} else if(i == 5) {
				simpleBookNames = "Haste";
			} else if(i == 6) {
				simpleBookNames = "Headless";
			} else if(i == 7) {
				simpleBookNames = "Healing";
			} else if(i == 8) {
				simpleBookNames = "Insomnia";
			} else if(i == 9) {
				simpleBookNames = "Lightning";
			} else if(i == 10) {
				simpleBookNames = "Nutrition";
			} else if(i == 11) {
				simpleBookNames = "Obliterate";
			} else if(i == 12) {
				simpleBookNames = "Oxygenate";
			} else if(i == 13) {
				simpleBookNames = "ThunderingBlow";
			}
			for(int o = 1; o <= 10; o++) {
				if(!(simpleBookNames == null)
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookNames + "." + simpleBookNames + o + ".BookName") == null)
						&& !(simpleBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookNames + "." + simpleBookNames + o + ".BookName"))))
						&& !(RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookNames + "." + simpleBookNames + o + ".ItemLore") == null)
						&& !(EnchantBookNames.simpleBookNames.contains(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookNames + "." + simpleBookNames + o + ".BookName"))))
						&& RandomPackage.getEnabledEnchantsConfig().getString("Simple." + simpleBookNames).equalsIgnoreCase("true")) {
					EnchantBookNames.simpleBookNames.add(ChatColor.translateAlternateColorCodes('&', RandomPackage.getPlugin().getConfig().getString("Enchantments.Simple." + simpleBookNames + "." + simpleBookNames + o + ".BookName")));
				}
			}
		}
		return;
	}
	public static ArrayList<String> getSoulBookNames() { return soulBookNames; }
	public static ArrayList<String> getLegendaryBookNames() { return legendaryBookNames; }
	public static ArrayList<String> getUltimateBookNames() { return ultimateBookNames; }
	public static ArrayList<String> getEliteBookNames() { return eliteBookNames; }
	public static ArrayList<String> getUniqueBookNames() { return uniqueBookNames; }
	public static ArrayList<String> getSimpleBookNames() { return simpleBookNames; }
}
