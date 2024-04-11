/**
 * this is the User class where the fields, constructors, getter and setter resides.
 */

package com.user.management.appl.model.user;

import java.sql.Timestamp;
/**
 * POJO class for User objects. This class represents the User information.
 * */
public class User {
    private int id;
    private String username;
    private String password;
    private String entity_id;
    private Timestamp date_created;
    private Timestamp date_modified;
    /***
     * Default constructor of the User class.
     */
    public User() {

    }
    /***
     * An User class constructor that initializes the id, username, password, entity id, date created and date modified of the User instance.
     * @param id is the id of the user.
     * @param username is the username of the user.
     * @param password is the password of the user.
     * @param entity_id is the entity id of the user.
     * @param date_created is the date created of the user.
     * @param date_modified is the date modified by the user.
     */
    public User(int id, String username, String password, String entity_id, Timestamp date_created, Timestamp date_modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.entity_id = entity_id;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }
    /**
     * This gets the User Id.
     * @return the user's Id.
     */
    public int getId() { return id; }
    /**
     * This sets the user id
     * @param id is the ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * This gets the User Username.
     * @return the user's username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * This sets the user username
     * @param username is the username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * This gets the User password.
     * @return the user's password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * This sets the user password
     * @param password is the password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * This gets the User entity id
     * @return the user's entity id.
     */
    public String getEntity_id() {
        return entity_id;
    }
    /**
     * This sets the user entity id
     * @param entity_id is the entity id to be set.
     */
    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }
    /**
     * This gets the User date created.
     * @return the user's date created.
     */
    public Timestamp getDate_created() {
        return date_created;
    }
    /**
     * This sets the user date created
     * @param date_created is the date created to be set.
     */
    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }
    /**
     * This gets the User date modified.
     * @return the user's date modified.
     */
    public Timestamp getDate_modified() {
        return date_modified;
    }
    /**
     * This sets the user date modified
     * @param date_modified is the date modified to be set.
     */
    public void setDate_modified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }
}
