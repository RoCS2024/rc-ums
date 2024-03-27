/**
 * this is the User class where the fields, constructors, getter and setter resides.
 */

package com.user.management.appl.model.user;

import java.sql.Timestamp;
/**
 * This is the User Model.
 * */
public class User {
    /**
     * This is the User field.
     * */
    private int id;
    private String username;
    private String password;
    private String entity_id;
    private Timestamp date_created;
    private Timestamp date_modified;

    public User() {

    }

    public User(int id, String username, String password, String entity_id, Timestamp date_created, Timestamp date_modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.entity_id = entity_id;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }
    /**
     * This is the User getter and setter.
     * */

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public Timestamp getDate_created() {
        return date_created;
    }

    public void setDate_created(Timestamp date_created) {
        this.date_created = date_created;
    }

    public Timestamp getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Timestamp date_modified) {
        this.date_modified = date_modified;
    }

    public Object getEmail() {
        return null;
    }
}
