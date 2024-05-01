package com.user.management.data.utils;

/**
 * Inside the QueryConstants class contains constants representing SQL queries for managing user
 */
public class QueryConstant {

    public static final String GET_USER_BY_USERNAME_STATEMENT = "SELECT * FROM login WHERE username=?";

    public static final String SAVE_USER_STATEMENT = "INSERT INTO login (ID, USERNAME, PASSWORD, ENTITY_ID, DATE_CREATED, DATE_MODIFIED) VALUES (?, ?, ?, ?, ?, ?)";


    public static final String GET_MAX_USER_ID_STATEMENT = "SELECT MAX(ID) AS MAX_ID FROM login";


    public static final String GET_ALL_USER_STATEMENT = "SELECT * FROM LOGIN";

    public static final String GET_USER_BY_ID_STATEMENT = "SELECT * FROM login WHERE id = ?";

    public static final String UPDATE_USER_STATEMENT = "UPDATE login SET username = ?, password = ?, entity_id = ?, date_modified = ? WHERE id = ?";

    public static final String GET_USERNAME_STATEMENT = "SELECT * FROM login WHERE username=?";

    public static final String UPDATE_PASSWORD_STATEMENT = "UPDATE login SET password=?, date_modified=? WHERE username=?";

    public static final String GET_PASSWORD_BY_USERNAME_STATEMENT = "SELECT password FROM login WHERE username=?";

    public static final String FORGOT_PASSWORD_STATEMENT = "UPDATE login SET password=?, date_modified=? WHERE username=?";

}
