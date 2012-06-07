package me.zippy120;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RandomPlacer extends JavaPlugin {
	
	Logger log;
	Random r = new Random();
 
	public void onEnable(){
		log = this.getLogger();
		log.info("Your plugin has been enabled!");
	}
 
	public void onDisable(){
		log.info("Your plugin has been disabled.");
	}
	 
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if ((sender instanceof Player)) {
			Player player = (Player) sender;
				if(cmd.getName().equalsIgnoreCase("tpr")){
					int xlimit;
					int zlimit;
					int nxlimit;
					int nzlimit;
					if (getConfig().getInt("limit.x") != 0 && getConfig().getInt("limit.z") != 0){
					xlimit = getConfig().getInt("limit.x");					
					zlimit = getConfig().getInt("limit.z");
					if (getConfig().getInt("limit.nx") != 0 && getConfig().getInt("limit.nz") != 0){
						nxlimit = getConfig().getInt("limit.nx");					
						nzlimit = getConfig().getInt("limit.nz");
						if (nxlimit > xlimit || nzlimit > zlimit){
							log.info(getConfig().getString("Error.NumberConflict"));
							xlimit = 1000;
							nxlimit = -1000;
							zlimit = 1000;
							nzlimit = -1000;
						}
					} else {
					nzlimit = zlimit - (zlimit * 2);
					nxlimit = xlimit - (xlimit * 2);
					log.info(getConfig().getString("Error.NNumberNotSet"));
					}
					
					} else {
					xlimit = 1000;
					nxlimit = -1000;
					zlimit = 1000;
					nzlimit = -1000;
					log.info(getConfig().getString("Error.NumberNotSet"));
					}
					int x = r.nextInt(xlimit - nxlimit + 1) + nxlimit;
					int z = r.nextInt(zlimit - nzlimit + 1) + nzlimit;
					int y = player.getWorld().getHighestBlockYAt(x, z);
					Location l = new Location(player.getWorld(), x, y, z);	
						player.teleport(l);
						(player).sendMessage(ChatColor.GOLD + "[RandomPlacer]: " + ChatColor.YELLOW + getConfig().getString("Teleported") + " " + x + ", " + z);
						return true;
				}
					} else { 
						log.info(getConfig().getString("Error.ConsoleSender"));
					}
	       
			
		return false;
		
		
	}
}
