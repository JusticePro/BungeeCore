package me.justicepro.bungeecore;

import net.md_5.bungee.api.ProxyServer;

public class Plugin extends net.md_5.bungee.api.plugin.Plugin {
	
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new ServerCommand());
	}
	
}