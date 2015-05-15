package net.tylerhyperHD.TylerBot;

import java.util.logging.Logger;
import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import net.tylerhyperHD.TylerBot.Commands.BukkitCommandHandler;
import net.tylerhyperHD.TylerBot.Commands.Command_tylerbot;
import net.tylerhyperHD.TylerBot.Listener.MainListener;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;


public class TylerBot extends BukkitPlugin {
    public TylerBot plugin;
    public Logger logger;
    public BukkitCommandHandler handler;
    public static final String BOT_MSG_CHAT_TAG = ChatColor.GOLD + "[" + ChatColor.RED + "TylerBotHD " + ChatColor.GOLD + "-> me]" + ChatColor.WHITE + " ";
    public static final String BOT_CHAT_TAG = ChatColor.WHITE + "<" + ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Bot" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "tylerbotHD" + ChatColor.WHITE +">";
    public static Server server;
    
    @Override
    public void onLoad() {
        this.plugin = this;
        this.handler = new BukkitCommandHandler(plugin);
        this.logger = plugin.getLogger();
        TylerBot.server = plugin.getServer();
    }

    @Override
    public void onEnable() {
        BukkitLib.init(plugin);
        handler.setCommandLocation(Command_tylerbot.class.getPackage());
        final PluginManager pm = server.getPluginManager();
        pm.registerEvents(new MainListener(), plugin);
        logger.info(plugin.getName() + " v" + plugin.getVersion() + " is enabled"); 
        logger.info("TylerBot made by tylerhyperHD");
    }


    @Override
    public void onDisable() {
        logger.info(plugin.getName() + " is disabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }
}