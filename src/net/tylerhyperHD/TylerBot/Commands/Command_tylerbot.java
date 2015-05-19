package net.tylerhyperHD.TylerBot.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.ANY, permission = "tylerbot.*")
public class Command_tylerbot extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        sender.sendMessage(ChatColor.GREEN + "Running TylerBot Version 1.5");
        sender.sendMessage(ChatColor.ITALIC + "TylerBot was made to work as a plugin that destroys the common errors that people make.");
        sender.sendMessage(ChatColor.AQUA + "TylerBot created and made by tylerhyperHD");
        return true;  
    }
}