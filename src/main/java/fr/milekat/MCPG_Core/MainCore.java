package fr.milekat.MCPG_Core;

import fr.milekat.MCPG_Core.utils.ConnectionsLoad;
import fr.milekat.MCPG_Core.utils.MariaDB;
import fr.milekat.MCPG_Core.utils.MongoDB;
import net.jitse.npclib.NPCLib;
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
    private static NPCLib library;
    private static MongoDB mongoDB;
    private static MariaDB mariaDB;

    public static String prefix = "[MCPG-Core] ";

    @Override
    public void onEnable() {
        // JSON config file load
        setJsonConfig();
        //  Load all connections
        new ConnectionsLoad(this, mongoDB, mariaDB);
        //  Enable NPCLib API
        library = new NPCLib(this);
    }

    @Override
    public void onDisable() {

    }

    private void setJsonConfig() {
        try {
            configRoot = (JSONObject) new JSONParser().parse(new FileReader("plugins/MCPG-Core/config.json"));
        } catch (IOException | ParseException e) {
            Bukkit.getLogger().warning(MainCore.prefix + "Config not found, disabling the plugin.");
        }
    }

    public static JSONObject getJsonConfig(){ return configRoot; }

    public static NPCLib getNPCLib() { return library; }

    public static MongoDB getMongoDB() { return mongoDB; }

    public static Connection getSql() { return mariaDB.getConnection(); }
}
