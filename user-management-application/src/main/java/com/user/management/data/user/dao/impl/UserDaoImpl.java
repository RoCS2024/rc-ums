/**
 * This serves as a class that implements the UserDao
 *
 */


package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM login WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        String sql = "INSERT INTO login (username, password, entity_id, date_created, date_modified) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            //stmt.setInt(1, user.getId());
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEntity_id());
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            stmt.setTimestamp(4, currentTimestamp);
            stmt.setTimestamp(5, currentTimestamp);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE login SET username = ?, password = ?, entity_id = ?, date_modified = ? WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEntity_id());
            stmt.setTimestamp(4, user.getDate_modified());
            stmt.setInt(5, user.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String entity_id = rs.getString("entity_id");
        Timestamp date_modified = rs.getTimestamp("date_modified");
        return new User(id, username, password, entity_id, null, date_modified);
    }
}
