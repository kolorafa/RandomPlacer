package me.zippy120;

import org.bukkit.entity.Player;

public class PlayerJoinEvent{
private RandomPlacer plugin;


	public PlayerJoinEvent(PlayerJoinEvent event, Player playerJoined){
		Player player = playerJoined;
		if (!plugin.getHash().get(player))
		plugin.getHash().get(true);
		plugin.TrueHash(player);
	}
}
