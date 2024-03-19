package com.user.management.data.user.dao.impl;

import com.user.management.app.model.user.User;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.user.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This is the User Dao Impl.
 * */
public class UserDaoImpl implements UserDao {
    /**
     * This is for findUserByUsernameAndPassword.
     * */
    @Override

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return User;
    }
    /**
     * This is for save user.
     * */
    @Override
    public User saveUser(User User)  {

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return User;
    }
    /**
     * This is for getMaxUserId.
     * */
    @Override
    public long getMaxUserId(){

        String selectMaxIdQuery = "SELECT MAX(ID) AS MAX_ID FROM login";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectMaxIdQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("MAX_ID");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    /**
     * This is for get all user.
     * */
    @Override
    public List<User> getAllUsers(){

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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return userList;
    }
    /**
     * This is for get user by id.
     * */
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
        } catch (Exception ex) {
            System.err.println("Error retrieving user with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * This is for update user.
     * */
    @Override
    public boolean updateUser() {
        String sql = "UPDATE login SET username = ?, password = ?, entity_id = ?, date_modified = ? WHERE id = ?";
        User user = new User();

        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEntity_id());
            stmt.setTimestamp(4, user.getDate_modified());
            stmt.setInt(5, user.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception ex) {
            System.err.println("Error updating user with ID " + user.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    /**
     * This is for get username.
     * */
    @Override
    public User getUsername(String username) {
        String selectByIdQuery = "SELECT * FROM login WHERE username=?";
        User login = null;

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)) {
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    login = new User();
                    login.setId((int) resultSet.getLong("id"));
                    login.setUsername(resultSet.getString("username"));
                    login.setPassword(resultSet.getString("password"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return login;
    }
    /**
     * This is for update password.
     * */
    @Override
    public User updatePassword(User user) {
        String updateQuery = "UPDATE login SET password=?, date_modified=? WHERE username=?";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(3, user.getUsername());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new RuntimeException("Password update failed.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating password: " + e.getMessage(), e);
        }
        return user;
    }
}
