package fr.milekat.MCPG_Core.utils;

import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.json.simple.JSONObject;

public class ConnectionsLoad {

    public ConnectionsLoad(Plugin plugin, MongoDB mongoDB, MariaDB mariaDB) {
        //  MongoDB login
        JSONObject mongoConf = (JSONObject) MainCore.getJsonConfig().get("MongoDB");
        if (mongoConf!=null) {
            mongoDB = new MongoDB((String) mongoConf.get("host"),
                    (Integer) mongoConf.get("port"),
                    (String) mongoConf.get("db"),
                    (String) mongoConf.get("user"),
                    (String) mongoConf.get("mdp"));
        } else {
            Bukkit.getLogger().warning(MainCore.prefix + "MongoDB config not found, disabling the plugin.");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
        //  MariaDB login
        JSONObject sqlConf = (JSONObject) MainCore.getJsonConfig().get("SQL");
        if (mongoConf!=null) {
            mariaDB = new MariaDB((String) sqlConf.get("driver"),
                    (String) sqlConf.get("url"),
                    (String) sqlConf.get("host"),
                    (Integer) sqlConf.get("port"),
                    (String) sqlConf.get("db"),
                    (String) sqlConf.get("user"),
                    (String) sqlConf.get("mdp"));
        } else {
            Bukkit.getLogger().warning(MainCore.prefix + "MongoDB config not found, disabling the plugin.");
            Bukkit.getPluginManager().disablePlugin(plugin);
        }
    }
}
