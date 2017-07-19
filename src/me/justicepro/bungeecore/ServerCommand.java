package me.justicepro.bungeecore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServerCommand extends Command {

	public ServerCommand() {
		super("server");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if (sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;

			if (args.length>=1) {
				try {
					ServerInfo target = ProxyServer.getInstance().getServerInfo(args[0]);
					player.connect(target);
					player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&',
							"&9Portal>&7 You have been from &6" + player.getServer().getInfo().getName() + "&7 to &6" + args[0] + "&7.")));
				}catch (Exception e) {
					player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&',
							"&9Portal>&7 Couldn't find server &6" + args[0] + "&7.")));
				}
			}else {
				player.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&',
						"&9Portal>&7 You are on server &6" + player.getServer().getInfo().getName() + "&7.")));
			}

		}

	}

}