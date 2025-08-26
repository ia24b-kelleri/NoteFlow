package org.example.noteflow;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Db {

    private static HikariDataSource ds;

    static {
        HikariConfig cfg = new HikariConfig();

        // JDBC-URL für deine DB "NoteFlow"
        cfg.setJdbcUrl("jdbc:mariadb://localhost:3306/NoteFlow?useUnicode=true&characterEncoding=UTF-8");

        // Zugangsdaten  -> das sind die Werte, die du in MariaDB mit CREATE USER angelegt hast
        cfg.setUsername("appuser");   // z. B. dein DB-User
        cfg.setPassword("secret");    // z. B. dein DB-Passwort

        // Pool-Settings
        cfg.setDriverClassName("org.mariadb.jdbc.Driver");
        cfg.setMaximumPoolSize(10);          // bis zu 10 gleichzeitige Verbindungen
        cfg.setMinimumIdle(2);               // 2 Verbindungen werden im Leerlauf gehalten
        cfg.setConnectionTimeout(10000);     // 10 Sekunden Timeout
        cfg.setIdleTimeout(60000);           // 60 Sekunden Idle-Verbindungen offen lassen

        ds = new HikariDataSource(cfg);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
