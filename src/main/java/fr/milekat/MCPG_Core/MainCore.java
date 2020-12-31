package fr.milekat.MCPG_Core;

import net.jitse.npclib.NPCLib;
import org.bukkit.plugin.java.JavaPlugin;

public class MainCore extends JavaPlugin {
    private static NPCLib library;

    @Override
    public void onEnable() {
        library = new NPCLib(this);
    }

    @Override
    public void onDisable() {

    }

    public static NPCLib getNPCLib() {
        return library;
    }
}
