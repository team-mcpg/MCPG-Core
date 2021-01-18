package fr.milekat.MCPG_Core.utils;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;

import java.util.Collections;

public class MongoDB {
    private final MongoClient mongoClient;

    public MongoDB(String hostname, Long port, String user, String db, String password) {
        MongoClientSettings settings = MongoClientSettings.builder()
                .credential(MongoCredential.createCredential(user, db, password.toCharArray()))
                .applyToSslSettings(builder -> builder.enabled(true))
                .applyToClusterSettings(builder -> builder.hosts(Collections.singletonList(
                        new ServerAddress(hostname, Math.toIntExact(port)))))
                .build();
        mongoClient = MongoClients.create(settings);
        Bukkit.getLogger().info(MainCore.prefix + "MongoDB connected !");
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
