package fr.milekat.MCPG_Core.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class MongoDB {
    private final MongoClient mc;

    public MongoDB(String hostname, Long port, String user, String db, String password) {
        ServerAddress addr = new ServerAddress(hostname, Math.toIntExact(port));
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(MongoCredential.createCredential(user, db, password.toCharArray()));
        mc = new MongoClient(addr, credentials);
        Bukkit.getLogger().info(MainCore.prefix + "MongoDB connected !");
    }

    public MongoClient getMongoClient() {
        return mc;
    }
}
