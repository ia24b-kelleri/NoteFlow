package org.example.noteflow;



import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Db {
    private static HikariDataSource ds;

    static {
        HikariConfig cfg = new HikariConfig();
        cfg.setJdbcUrl("jdbc:mariadb://localhost:3306/mydb");
        cfg.setUsername("root");
        cfg.setPassword("admin123");
        cfg.setMaximumPoolSize(10);

        ds = new HikariDataSource(cfg);
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }/*ffff*/
}
