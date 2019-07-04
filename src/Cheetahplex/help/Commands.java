package Cheetahplex.help;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {


    private final Help plugin;

    public Commands(Help instance) {
        plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        String a = plugin.getConfig().getString("help-message");
        String m = plugin.getConfig().getString("1-argMSG");
        String s = plugin.getConfig().getString("No-permission");
        String g = plugin.getConfig().getString("NotEnabled");

        if (cmd.getLabel().equalsIgnoreCase("help")) {
            if(plugin.getConfig().getBoolean("helpEnabled" , true)) {
                if (sender instanceof Player) {
                    if (args.length == 0) {
                        if (p.hasPermission("cheetah.help")) {
                            p.sendMessage(a.replace("&", "§"));
                        } else if (!(p.hasPermission("cheetah.help"))) {
                            p.sendMessage(s.replace("&", "§"));
                        }
                    } else {
                        p.sendMessage(m.replace("&", "§"));
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "You must be online to use this command");
                    return true;
                }
            }else {
                p.sendMessage(g.replace("&" , "§"));
            }
        }




        return false;
    }
}
