package fr.milekat.MCPG_Core.db;

import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;

public class ConnectionsLoad {

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
            Bukkit.getLogger().warning(MainCore.PREFIX + "MariaDB config not found, disabling the plugin.");
        }
        return null;
    }
}
