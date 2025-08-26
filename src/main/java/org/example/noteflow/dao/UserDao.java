package org.example.noteflow.dao;

import org.example.noteflow.Db;
import org.example.noteflow.model.User;

import java.sql.*;
import java.util.*;

public class UserDao {

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users ORDER BY user_id";
        try (Connection c = Db.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                users.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB-Fehler: " + e.getMessage(), e);
        }
        return users;
    }

    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";
        try (Connection c = Db.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB-Fehler: " + e.getMessage(), e);
        }
        return null;
    }

    private User map(ResultSet rs) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("user_id"));
        u.setFirstName(rs.getString("first_name"));
        u.setLastName(rs.getString("last_name"));
        u.setBirthday(rs.getDate("birthday").toLocalDate());
        u.setEmail(rs.getString("email"));
        u.setGender(rs.getString("gender"));
        u.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        u.setSubscriptionType(rs.getString("subscription_type"));
        u.setActive(rs.getBoolean("active"));
        return u;
    }
}
