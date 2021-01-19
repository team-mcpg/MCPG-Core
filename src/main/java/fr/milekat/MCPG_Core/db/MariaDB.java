package fr.milekat.MCPG_Core.db;

import fr.milekat.MCPG_Core.MainCore;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB {
    private Connection connection;
    private final String driver,url,host,database,user,pass;
    private final Long port;

    public MariaDB(String driver, String url, String host, Long port, String database, String user, String pass){
        this.driver = driver;
        this.url = url;
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.pass = pass;
    }

    /**
     *      Init de la connection SQL
     */
    public void connection(){
        try {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(url + host + ":" + port + "/" + database +
                    "?autoReconnect=true&allowMultiQueries=true&characterEncoding=UTF-8", user, pass);
            Bukkit.getLogger().info(MainCore.prefix + "MariaDB connected !");
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning(MainCore.prefix + "MariaDB error.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning(MainCore.prefix + "MariaDB class error.");
        }
    }

    /**
     *      LogOut du SQL
     */
    public void disconnect(){
        try {
            connection.close();
            Bukkit.getLogger().warning(MainCore.prefix + "MariaDB disconnected !");
        } catch (SQLException e) {
            e.printStackTrace();
            Bukkit.getLogger().warning(MainCore.prefix + "MariaDB error.");
        }
    }

    /**
     *      Retourne la connection pour initialiser un PreparedStatement
     *      @return connection
     */
    public Connection getConnection(){
        return connection;
    }
}
