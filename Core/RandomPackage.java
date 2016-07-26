package me.randomHashTags.randomPackage.Core;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.randomHashTags.randomPackage.Commands.RandomPackageCommand;
import me.randomHashTags.randomPackage.Commands.addlore;
import me.randomHashTags.randomPackage.Commands.newGivedp;
import me.randomHashTags.randomPackage.Commands.relore;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.BookFireworks;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookLores;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantBookNames;
import me.randomHashTags.randomPackage.RandomArmorEffects.Books.EnchantType;
import me.randomHashTags.randomPackage.RandomArmorEffects.Commands.kitop;
import me.randomHashTags.randomPackage.RandomArmorEffects.Commands.levelcap;
import me.randomHashTags.randomPackage.RandomArmorEffects.Commands.randomEnchantBooks;
import me.randomHashTags.randomPackage.RandomArmorEffects.Commands.bookGui.BookGui;
import me.randomHashTags.randomPackage.RandomArmorEffects.Commands.bookGui.BookGuiListener;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.EnchantsThatAddPotionEffects;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.EntityDamageByEntityEnchants;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.TargetEvent;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.HellFire;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Implants;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.SkillSwipe;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Spirits;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Teleportation;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Trap;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.UndeadRuse;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Vampire;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Elite.Virus;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary.Disarmor;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary.Ghost;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary.Inquisitive;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Legendary.Rage;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.NotFinished.Epicness;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Decapitation;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Haste;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Headless;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Healing;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Lightning;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Simple.Oxygenate;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate.CreeperArmor;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate.Detonate;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate.Piercing;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate.Shackle;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Ultimate.Unfocus;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.AutoSmelt;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.Cowification;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.Experience;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.Explosive;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.ObsidianDestroyer;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.Unique.Reforged;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.factionEnchants.Cleave;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.factionEnchants.Commander;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.factionEnchants.Protection;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.factionEnchants.Pummel;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO.Greatsword;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO.Nimble;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO.Skilling;
import me.randomHashTags.randomPackage.RandomArmorEffects.Enchants.mcMMO.Training;
import me.randomHashTags.randomPackage.RandomArmorEffects.GlobalEvents.globalEvents;
import me.randomHashTags.randomPackage.RandomArmorEffects.Soul.newSoul;
import me.randomHashTags.randomPackage.RandomArmorEffects.Soul.soulAdd;
import me.randomHashTags.randomPackage.RandomArmorEffects.Soul.splitsouls;
import me.randomHashTags.randomPackage.RandomArmorEffects.SuccessAndDestroy.SuccessAndDestroySystem;
import me.randomHashTags.randomPackage.RandomPlus.Bosses.KingSlime;
import me.randomHashTags.randomPackage.RandomPlus.Commands.gkitCommand;
import me.randomHashTags.randomPackage.RandomPlus.Events.gkitListener;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.NPCinteract;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Alchemist.alchemistCommand;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Alchemist.alchemistEvent;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Enchanter.enchanterCommand;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Enchanter.enchanterListener;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer.newDustAndFireballs;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer.tinkererCommand;
import me.randomHashTags.randomPackage.TinkererEnchanterAlchemist.Tinkerer.tinkererEvent;
import me.randomHashTags.randomPackage.givedpItems.BlackScrolls;
import me.randomHashTags.randomPackage.givedpItems.ItemNameTags;
import me.randomHashTags.randomPackage.givedpItems.MysteryMobSpawners;
import me.randomHashTags.randomPackage.givedpItems.TransmogScrolls;
import me.randomHashTags.randomPackage.givedpItems.WhiteScrolls;
import net.milkbowl.vault.economy.Economy;

public class RandomPackage extends JavaPlugin {
	private static FileConfiguration config;
	private static File configF, RandomPlusF, TinkererF, EnchanterF, EnabledEnchantsF, SoulF, MMSF, globalEventsF, BookOptionsF, alchemistF, givedpItemsF, placeholderF, gkitsF, dropPackageF;
	private static FileConfiguration RandomPlus, Tinkerer, Enchanter, EnabledEnchants, Soul, MMS, globalEvents, BookOptions, alchemist, givedpItems, placeholder, gkits, dropPackage;
	
	public static Economy econ = null;
	
	private PluginManager pm = getServer().getPluginManager();
	public static Plugin plugin;
	public static Plugin getPlugin() { return plugin; }
	
	private boolean setupEconomy() {
		if(getServer().getPluginManager().getPlugin("Vault") == null) { return false; }
	    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	    if(rsp == null) { return false; } econ = rsp.getProvider(); return econ != null;
	}
	
	public void onEnable() {
		configSetup();
		setupEconomy();
		plugin = this;
		RandomArmorEffects();
		registerEnchants();
		givedpItems();
		TinkererEnchanterAlchemist();
		RandomPlus();
		
		factionEnchants();
		mcMMOEnchants();
		
		if(!(setupEconomy())) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
		}
	}
	
	
	
	private void configSetup() {
		
		configF = new File(getDataFolder(), "config.yml");
		RandomPlusF = new File(getDataFolder(), "Random+.yml");
		TinkererF = new File(getDataFolder(), "Tinkerer.yml");
		EnabledEnchantsF = new File(getDataFolder(), "EnabledEnchants.yml");
		SoulF = new File(getDataFolder(), "Soul.yml");
		MMSF = new File(getDataFolder(), "MysteryMobSpawners.yml");
		globalEventsF = new File(getDataFolder(), "GlobalEvents.yml");
		BookOptionsF = new File(getDataFolder(), "BookOptions.yml");
		alchemistF = new File(getDataFolder(), "Alchemist.yml");
		givedpItemsF = new File(getDataFolder(), "givedpItems.yml");
		placeholderF = new File(getDataFolder(), "_placeholders.yml");
		EnchanterF = new File(getDataFolder(), "Enchanter.yml");
		gkitsF = new File(getDataFolder(), "gkits.yml");
		dropPackageF = new File(getDataFolder(), "dropPackage.yml");
		if(!(configF.exists())) { configF.getParentFile().mkdirs(); saveResource("config.yml", false); }
		if(!(RandomPlusF.exists())) { RandomPlusF.getParentFile().mkdirs(); saveResource("Random+.yml", false); }
		if(!(TinkererF.exists())) { TinkererF.getParentFile().mkdirs(); saveResource("Tinkerer.yml", false); }
		if(!(EnabledEnchantsF.exists())) { EnabledEnchantsF.getParentFile().mkdirs(); saveResource("EnabledEnchants.yml", false); }
		if(!(SoulF.exists())) { SoulF.getParentFile().mkdirs(); saveResource("Soul.yml", false); }
		if(!(MMSF.exists())) { MMSF.getParentFile().mkdirs(); saveResource("MysteryMobSpawners.yml", false); }
		if(!(globalEventsF.exists())) { globalEventsF.getParentFile().mkdirs(); saveResource("GlobalEvents.yml", false); }
		if(!(BookOptionsF.exists())) { BookOptionsF.getParentFile().mkdirs(); saveResource("BookOptions.yml", false); }
		if(!(alchemistF.exists())) { alchemistF.getParentFile().mkdirs(); saveResource("Alchemist.yml", false); }
		if(!(givedpItemsF.exists())) { givedpItemsF.getParentFile().mkdirs(); saveResource("givedpItems.yml", false); }
		if(!(placeholderF.exists())) { placeholderF.getParentFile().mkdirs(); saveResource("_placeholders.yml", false); }
		if(!(EnchanterF.exists())) { EnchanterF.getParentFile().mkdirs(); saveResource("Enchanter.yml", false); }
		if(!(gkitsF.exists())) { gkitsF.getParentFile().mkdirs(); saveResource("gkits.yml", false); }
		if(!(dropPackageF.exists())) { dropPackageF.getParentFile().mkdirs(); saveResource("dropPackage.yml", false); }
		
		
		config = new YamlConfiguration();
		RandomPlus = new YamlConfiguration();
		Tinkerer = new YamlConfiguration();
		EnabledEnchants = new YamlConfiguration();
		Soul = new YamlConfiguration();
		MMS = new YamlConfiguration();
		globalEvents = new YamlConfiguration();
		BookOptions = new YamlConfiguration();
		alchemist = new YamlConfiguration();
		givedpItems = new YamlConfiguration();
		placeholder = new YamlConfiguration();
		Enchanter = new YamlConfiguration();
		gkits = new YamlConfiguration();
		dropPackage = new YamlConfiguration();
		try {
			config.load(configF);
			RandomPlus.load(RandomPlusF);
			Tinkerer.load(TinkererF);
			EnabledEnchants.load(EnabledEnchantsF);
			Soul.load(SoulF);
			MMS.load(MMSF);
			globalEvents.load(globalEventsF);
			BookOptions.load(BookOptionsF);
			alchemist.load(alchemistF);
			givedpItems.load(givedpItemsF);
			placeholder.load(placeholderF);
			Enchanter.load(EnchanterF);
			gkits.load(gkitsF);
			dropPackage.load(dropPackageF);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	public static FileConfiguration getRandomPlusConfig() { return RandomPlus; }
	public static FileConfiguration getTinkererConfig() { return Tinkerer; }
	public static FileConfiguration getEnchanterConfig() { return Enchanter; }
	public static FileConfiguration getEnabledEnchantsConfig() { return EnabledEnchants; }
	public static FileConfiguration getSoulConfig() { return Soul; }
	public static FileConfiguration getMysteryMobSpawnerConfig() { return MMS; }
	public static FileConfiguration getAlchemistConfig() { return alchemist; }
	public static FileConfiguration getGlobalEventsConfig() { return globalEvents; }
	public static FileConfiguration getBookOptionsConfig() { return BookOptions; }
	public static FileConfiguration getGivedpItemsConfig() { return givedpItems; }
	public static FileConfiguration getPlaceholderConfig() { return placeholder; }
	public static FileConfiguration getGkitConfig() { return gkits; }
	public static FileConfiguration getDropPackageConfig() { return dropPackage; }
	
	private void RandomPlus() {
		getCommand("gkit").setExecutor(new gkitCommand());
		pm.registerEvents(new gkitListener(), this);
		pm.registerEvents(new KingSlime(), this);
	}
	
	private void TinkererEnchanterAlchemist() {
		getCommand("tinkerer").setExecutor(new tinkererCommand());
		getCommand("enchanter").setExecutor(new enchanterCommand());
		getCommand("alchemist").setExecutor(new alchemistCommand());
		pm.registerEvents(new tinkererEvent(), this);
		pm.registerEvents(new enchanterListener(), this);
		pm.registerEvents(new alchemistEvent(), this);
		pm.registerEvents(new NPCinteract(), this);
	}
	
	public void givedpItems() {
		pm.registerEvents(new MysteryMobSpawners(), this);
		pm.registerEvents(new ItemNameTags(), this);
		pm.registerEvents(new TransmogScrolls(), this);
		pm.registerEvents(new WhiteScrolls(), this);
		pm.registerEvents(new newDustAndFireballs(), this);
		pm.registerEvents(new BlackScrolls(), this);
		pm.registerEvents(new newSoul(), this);
	}
	
	
	public void RandomArmorEffects() {
		getCommand("splitsouls").setExecutor(new splitsouls());
		getCommand("levelCap").setExecutor(new levelcap());
		getCommand("kitop").setExecutor(new kitop());
		getCommand("givedp").setExecutor(new newGivedp());
		getCommand("randomenchantbooks").setExecutor(new randomEnchantBooks());
		getCommand("randomBookGui").setExecutor(new BookGui());
		getCommand("RandomPackage").setExecutor(new RandomPackageCommand());
		getCommand("near").setExecutor(new Ghost());
		getCommand("addlore").setExecutor(new addlore());
		getCommand("relore").setExecutor(new relore());
		//getCommand("showcase").setExecutor(new showcase());
		
		pm.registerEvents(new BookFireworks(), this);
		pm.registerEvents(new EnchantType(), this);
		pm.registerEvents(new EnchantBookNames(), this);
		pm.registerEvents(new EnchantBookLores(), this);
		
		//pm.registerEvents(new DropPackageListener(), this);
		
		pm.registerEvents(new SuccessAndDestroySystem(), this);
		//pm.registerEvents(new itemChat(), this);
		
		pm.registerEvents(new soulAdd(), this);
		pm.registerEvents(new globalEvents(), this);
		
		pm.registerEvents(new BookGuiListener(), this);
		
		
	}
	private void registerEnchants() {
		pm.registerEvents(new EntityDamageByEntityEnchants(), this);
		pm.registerEvents(new TargetEvent(), this);
		
		pm.registerEvents(new Unfocus(), this);
		// Soul
		//pm.registerEvents(new Immortal(), this);
		//pm.registerEvents(new NaturesWrath(), this);
		
		pm.registerEvents(new EnchantsThatAddPotionEffects(), this);
		
		// Legendary
		pm.registerEvents(new CreeperArmor(), this);
		//pm.registerEvents(new KillAura(), this);
		pm.registerEvents(new Rage(), this);
		
		// Ultimate
		pm.registerEvents(new Detonate(), this);
		pm.registerEvents(new Disarmor(), this);
		pm.registerEvents(new Experience(), this);
		pm.registerEvents(new Inquisitive(), this);
		pm.registerEvents(new Piercing(), this);
		pm.registerEvents(new Shackle(), this);
		pm.registerEvents(new Spirits(), this);
		
		// Elite
		pm.registerEvents(new HellFire(), this);
		pm.registerEvents(new Implants(), this);
		pm.registerEvents(new Reforged(), this);
		pm.registerEvents(new SkillSwipe(), this);
		//pm.registerEvents(new Telepathy(), this);
		pm.registerEvents(new Teleportation(), this);
		pm.registerEvents(new Trap(), this);
		pm.registerEvents(new UndeadRuse(), this);
		pm.registerEvents(new Vampire(), this);
		pm.registerEvents(new Virus(), this);
		
		// Unique
		pm.registerEvents(new AutoSmelt(), this);
		pm.registerEvents(new Cowification(), this);
		pm.registerEvents(new Explosive(), this);
		pm.registerEvents(new ObsidianDestroyer(), this);
		//pm.registerEvents(new PlagueCarrier(), this);
		
		// Simple
		pm.registerEvents(new Decapitation(), this);
		pm.registerEvents(new Epicness(), this);
		pm.registerEvents(new Haste(), this);
		pm.registerEvents(new Headless(), this);
		pm.registerEvents(new Healing(), this);
		//pm.registerEvents(new Insomnia(), this);
		pm.registerEvents(new Lightning(), this);
		pm.registerEvents(new Oxygenate(), this);
	}
	@EventHandler
	private void pluginDisableEvent(PluginDisableEvent event) {
		Bukkit.getScheduler().cancelAllTasks();
		return;
	}
	private void factionEnchants() {
		if(!(Bukkit.getPluginManager().getPlugin("Factions") == null)) {
			// Legendary
			pm.registerEvents(new Protection(), this);
			// Ultimate
			pm.registerEvents(new Cleave(), this);
			// Elite
			pm.registerEvents(new Pummel(), this);
			// Unique
			pm.registerEvents(new Commander(), this);
			// Simple
		}
	}
	private void mcMMOEnchants() {
		if(!(Bukkit.getPluginManager().getPlugin("mcMMO") == null)) {
			pm.registerEvents(new Training(), this);
			pm.registerEvents(new Nimble(), this);
			pm.registerEvents(new Skilling(), this);
			pm.registerEvents(new Greatsword(), this);
		}
	}
}
