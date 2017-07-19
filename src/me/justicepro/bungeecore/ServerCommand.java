package me.justicepro.bungeecore;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
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
				ServerInfo target = ProxyServer.getInstance().getServerInfo(args[0]);
				player.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&',
						"&9Server>&7 You have been from &6" + player.getServer().getInfo().getName() + "&7 to &6" + args[0])).create());
				player.connect(target);
			}else {
				player.sendMessage(new ComponentBuilder(ChatColor.translateAlternateColorCodes('&',
						"&9Portal>&7 You are on server &6" + player.getServer().getInfo().getName())).create());
			}

		}

	}

}