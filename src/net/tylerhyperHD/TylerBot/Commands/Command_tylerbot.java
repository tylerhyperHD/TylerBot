package net.tylerhyperHD.TylerBot.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.ANY, permission = "tylerbot.*")
public class Command_tylerbot extends BukkitCommand {

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        sender.sendMessage("Running TylerBot Version 1");
        return true;  
    }
}
