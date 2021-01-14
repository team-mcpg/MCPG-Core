package fr.milekat.MCPG_Core.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;

public class MongoDB {
    private final MongoClient mc;

    public MongoDB(String hostname, Long port, String user, String db, String password) {
        mc = new MongoClient(new ServerAddress(hostname, Math.toIntExact(port)),
                MongoCredential.createCredential(user, db, password.toCharArray()),
                MongoClientOptions.builder().build());
        Bukkit.getLogger().info(MainCore.prefix + "MongoDB connected !");
    }

    public MongoClient getMongoClient() {
        return mc;
    }
}
