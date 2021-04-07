package fr.milekat.MCPG_Core.db;

import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLKeepalive {
    public SQLKeepalive(Plugin plugin) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
            try {
                PreparedStatement q = MainCore.getSql().prepareStatement("SELECT * FROM `ping`;");
                q.execute();
                q.close();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        },6000L, 6000L);
    }
}
