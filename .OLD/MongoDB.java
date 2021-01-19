package fr.milekat.MCPG_Core.db;
/*
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;

import java.util.Collections;
*/
public class MongoDB {/*
    private MongoClient mongoClient;

    public MongoDB(String hostname, Long port, String user, String db, String password) {
        try {
            MongoClientSettings settings = MongoClientSettings.builder()
                    .credential(MongoCredential.createCredential(user, db, password.toCharArray()))
                    .applyToClusterSettings(builder -> builder.hosts(Collections.singletonList(
                            new ServerAddress(hostname, Math.toIntExact(port)))))
                    .build();
            this.mongoClient = MongoClients.create(settings);
            Bukkit.getLogger().info(MainCore.prefix + "MongoDB connected !");
        } catch (Exception exception) {
            Bukkit.getLogger().warning(MainCore.prefix + "MongoDB ERROR : " + exception);
            exception.printStackTrace();
        }
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
*/}
