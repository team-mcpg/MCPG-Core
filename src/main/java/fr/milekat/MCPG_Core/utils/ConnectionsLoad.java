package fr.milekat.MCPG_Core.utils;

import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;

public class ConnectionsLoad {

    public static MongoDB getMongoDBConnections() {
        //  MongoDB login
        JSONObject mongoConf = (JSONObject) MainCore.getJsonConfig().get("MongoDB");
        if (mongoConf != null) {
            return new MongoDB((String) mongoConf.get("host"),
                    (Long) mongoConf.get("port"),
                    (String) mongoConf.get("db"),
                    (String) mongoConf.get("user"),
                    (String) mongoConf.get("mdp"));
        } else {
            Bukkit.getLogger().warning(MainCore.prefix + "MongoDB config not found, disabling the plugin.");
        }
        return null;
    }

    public static MariaDB getMariaDBConnections() {
        //  MariaDB login
        JSONObject sqlConf = (JSONObject) MainCore.getJsonConfig().get("SQL");
        if (sqlConf!=null) {
            return new MariaDB((String) sqlConf.get("driver"),
                    (String) sqlConf.get("url"),
                    (String) sqlConf.get("host"),
                    (Long) sqlConf.get("port"),
                    (String) sqlConf.get("db"),
                    (String) sqlConf.get("user"),
                    (String) sqlConf.get("mdp"));
        } else {
            Bukkit.getLogger().warning(MainCore.prefix + "MariaDB config not found, disabling the plugin.");
        }
        return null;
    }
}
