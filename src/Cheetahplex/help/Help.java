package Cheetahplex.help;

import org.bukkit.plugin.java.JavaPlugin;

public class Help extends JavaPlugin {


    @Override
    public void onEnable() {
        if(!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }


        getServer().getConsoleSender().sendMessage("Help plugin loading");
        getCommand("help").setExecutor(new Commands(this));

        reloadConfig();
        getConfig().addDefault("helpEnabled" , Boolean.valueOf(true));
        getConfig().addDefault("help-message" , "&5Basic help message");
        getConfig().addDefault("No-permission" , "&4Im sorry you cant use that command");
        getConfig().addDefault("1-argMSG" , "&4Syntax Error &r /help");
        getConfig().addDefault("NotEnabled" , "&4This command is currently not enabled");

        }
        }
