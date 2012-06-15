package me.zippy120;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	
	protected RandomPlacer plugin;
	
	
	/**
	 * 
	 * @param plugin
	 */
	public Config( RandomPlacer plugin ) {
		this.plugin = plugin;
	}
	
	
	/**
	 * 
	 * @param plugin
	 */
	public FileConfiguration getConfig(){
		
		FileConfiguration config = plugin.getConfig();
		
		// set defaults
		config.addDefault("limit.x", 500);
		config.addDefault("limit.y", 500);
		config.addDefault("limit.nx", -500);
		config.addDefault("limit.ny", -500);
		config.addDefault("Error.NumberConflict", "The numbers set in the config do not work. Setting to 1000...");
		config.addDefault("Error.NNumberNotSet", "The negative numbers in the config are not set. Defaulting to -1000...");
		config.addDefault("Error.NumberNotSet", "The numbers in the config are not set. Defaulting to 1000...");
		config.addDefault("Error.ConsoleSender", "You must be a player to execute this command.");
		config.addDefault("RandomPlacer.Teleported", "You are now at ");
		config.addDefault("RandomPlacer.Cooldown", 20);
		
		// Copy defaults
		config.options().copyDefaults(true);
		
		// save the defaults/config
		plugin.saveConfig();
		
		return config;
		
	}
}