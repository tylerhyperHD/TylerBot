package net.tylerhyperHD.TylerBot.Listener;

import net.tylerhyperHD.TylerBot.TylerBot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MainListener implements Listener
{
    int i = 10;
    TylerBot plugin;
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String chat = event.getMessage().toLowerCase();
        final Player player = event.getPlayer();
        
        if (plugin.config.getBoolean("freedomserver") == true)
        {
         if ((chat.contains("op me")))
         {
            if (!player.isOp()) {
                event.setCancelled(true);
                player.chat("give me op!");
                Bukkit.broadcastMessage(TylerBot.BOT_CHAT_TAG + "Here you go.");
                Bukkit.broadcastMessage(ChatColor.AQUA + "TylerBot - Opping " + player.getName());
                player.setOp(true);
             }
             else {
                 event.setCancelled(true);
                 player.sendMessage(TylerBot.BOT_MSG_CHAT_TAG + player.getName() + ", you are already op. Request denied!");
                }
             }
        }
  }
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
    {
        String command = event.getMessage();
        final Player player = event.getPlayer();
        command = command.toLowerCase().trim();
        if (command.contains("enderdragon") || command.contains("ender_dragon"))
        {
            event.setCancelled(true);
            player.sendMessage(TylerBot.BOT_CHAT_TAG + "No enderdragons! They are disabled because they simply crash the server.");
        }
        
        if ((command.contains("/op")))
        {
            if (!player.isOp()) {
                event.setCancelled(false);
            }
            else {
                event.setCancelled(true);
                player.sendMessage(TylerBot.BOT_CHAT_TAG + "You are already op, therefore your command was blocked!");
            }
        }
    }
}