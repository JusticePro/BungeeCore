package me.justicepro.bungeecore;

import net.md_5.bungee.api.plugin.Plugin;

public class BungeeCore extends Plugin {
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new ServerCommand());
	}
	
}