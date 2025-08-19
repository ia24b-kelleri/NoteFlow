package org.example.noteflow;

import java.sql.*;

public class DBTest {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/NoteFlow";
        String user = "webuser";
        String password = "MeinSicheresPasswort123!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
