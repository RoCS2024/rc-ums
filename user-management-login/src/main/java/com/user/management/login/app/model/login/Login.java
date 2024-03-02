package com.user.management.login.app.model.login;

import java.sql.Timestamp;

public class Login {
    private long id;
    private String username;
    private String password;
    private String entityId;
    private Timestamp dateCreated;
    private Timestamp dateModified;

    public Login() {
        this.dateCreated = new Timestamp(System.currentTimeMillis());
        this.dateModified = new Timestamp(System.currentTimeMillis());
    }

    public Login(long id, String username, String password, String entityId, Timestamp dateCreated, Timestamp dateModified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.entityId = entityId;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateModified() {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", entityId='" + entityId + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", dateModified='" + dateModified + '\'' +
                '}';
    }
}
