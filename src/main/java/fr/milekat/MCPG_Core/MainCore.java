package fr.milekat.MCPG_Core;

import fr.milekat.MCPG_Core.db.ConnectionsLoad;
import fr.milekat.MCPG_Core.db.MariaDB;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

public class MainCore extends JavaPlugin {
    private static JSONObject configRoot;
    private static MariaDB mariaDB;

    public static String prefix = "[MCPG] ";

    @Override
    public void onEnable() {
        // JSON config file load
        setJsonConfig();
        //  Load db connections
        mariaDB = ConnectionsLoad.getMariaDBConnections();
        if (mariaDB!=null) mariaDB.connection();
    }

    @Override
    public void onDisable() {
        mariaDB.disconnect();
    }

    private void setJsonConfig() {
        try {
            configRoot = (JSONObject) new JSONParser().parse(new FileReader("plugins/MCPG-Core/config.json"));
        } catch (IOException | ParseException e) {
            Bukkit.getLogger().warning(MainCore.prefix + "Config not found, disabling the plugin.");
        }
    }

    public static JSONObject getJsonConfig(){ return configRoot; }

    public static Connection getSql() { return mariaDB.getConnection(); }
}
