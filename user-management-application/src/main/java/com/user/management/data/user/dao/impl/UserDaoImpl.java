package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        String selectByIdQuery = "SELECT * FROM login WHERE username=?";
        User User = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    User = new User();
                    User.setId((int) resultSet.getLong("id"));
                    User.setUsername(resultSet.getString("username"));
                    User.setPassword(resultSet.getString("password"));
                    User.setEntity_id(resultSet.getString("entity_id"));
                    User.setDate_created(resultSet.getTimestamp("date_created"));
                    User.setDate_modified(resultSet.getTimestamp("date_modified"));
                }
            }
        }
        return User;
    }

    @Override
    public User saveUser(User User) throws SQLException {
        String insertQuery = "INSERT INTO login (ID, USERNAME, PASSWORD, ENTITY_ID, DATE_CREATED, DATE_MODIFIED) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            long MaxId = getMaxUserId();

            preparedStatement.setLong(1, MaxId + 1);
            preparedStatement.setString(2, User.getUsername());
            preparedStatement.setString(3, User.getPassword());
            preparedStatement.setString(4, User.getEntity_id());
            preparedStatement.setTimestamp(5, User.getDate_created());
            preparedStatement.setTimestamp(6, User.getDate_modified());
            preparedStatement.executeUpdate();
        }
        return User;
    }

    @Override
    public long getMaxUserId() throws SQLException {
        String selectMaxIdQuery = "SELECT MAX(ID) AS MAX_ID FROM login";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectMaxIdQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("MAX_ID");
            }
        }
        return 0;
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM LOGIN";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("ID"));
                user.setUsername(resultSet.getString("USERNAME"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setEntity_id(resultSet.getString("ENTITY_ID"));
                user.setDate_created(resultSet.getTimestamp("DATE_CREATED"));
                user.setDate_modified(resultSet.getTimestamp("DATE_MODIFIED"));
                userList.add(user);
            }
        }

        return userList;
    }
    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM login WHERE id = ?";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idNum = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String entity_id = rs.getString("entity_id");
                    Timestamp date_modified = rs.getTimestamp("date_modified");
                    return new User(idNum, username, password, entity_id, null, date_modified);
                } else {
                    System.err.println("No user found with ID: " + id);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error retrieving user with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
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
            System.err.println("Error updating user with ID " + user.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
}
