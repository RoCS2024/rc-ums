/**
 * The User class represents a user entity in the application.
 * It encapsulates attributes such as user ID, username, password, entity ID,
 * date of creation, and date of modification.
 */
package com.view.user.list.app.model.user;

import java.sql.Timestamp;
import java.util.Objects;

public class User {

    private int userId;

    private String userName;

    private String password;

    private String entityId;

    private Timestamp dateCreated;

    private Timestamp dateModified;

    /**
     * Retrieves the user ID.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user ID.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Retrieves the username.
     *
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     *
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the entity ID.
     *
     * @return The entity ID.
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * Sets the entity ID.
     *
     * @param entityId The entity ID to set.
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
     * Retrieves the date of creation.
     *
     * @return The date of creation.
     */
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the date of creation.
     *
     * @param dateCreated The date of creation to set.
     */
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Retrieves the date of modification.
     *
     * @return The date of modification.
     */
    public Timestamp getDateModified() {
        return dateModified;
    }

    /**
     * Sets the date of modification.
     *
     * @param dateModified The date of modification to set.
     */
    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

}
