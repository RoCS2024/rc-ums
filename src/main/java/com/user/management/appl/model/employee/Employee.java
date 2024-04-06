package com.user.management.appl.model.employee;

import java.sql.Timestamp;

/**
 * POJO class for Employee. This class represents the User Management Employee.
 * */

public class Employee {

    /** The last name of the employee. */
    private String lastName;

    /** The first name of the employee. */
    private String firstName;

    /** The middle name of the employee. */
    private String middleName;

    /** The position of the employee within the organization. */
    private String positionInRc;

    /** The date when the employee was employed. */
    private Timestamp dateEmployed;

    /** The birthdate of the employee. */
    private String birthdate;

    /** The birthplace of the employee. */
    private String birthplace;

    /** The gender of the employee. */
    private String sex;

    /** The civil status of the employee. */
    private String civilStatus;

    /** The citizenship of the employee. */
    private String citizenship;

    /** The religion of the employee. */
    private String religion;

    /** The height of the employee. */
    private double height;

    /** The weight of the employee. */
    private double weight;

    /** The email address of the employee. */
    private String email;

    /** The Social Security System number of the employee. */
    private String sssNo;

    /** The Tax Identification Number of the employee. */
    private String tinNo;

    /** The Pag-IBIG Fund number of the employee. */
    private String pagibigNo;

        /** A unique id of the Employee. */
    private String employeeId;

    /**
     * This is the Employee getter and setter.
     * */


    /**
     * Retrieves the last name of the employee.
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     * @param lastName The last name of the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the first name of the employee.
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     * @param firstName The first name of the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the middle name of the employee.
     * @return The middle name of the employee.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the middle name of the employee.
     * @param middleName The middle name of the employee.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Retrieves the position of the employee within the organization.
     * @return The position of the employee within the organization.
     */
    public String getPositionInRc() {
        return positionInRc;
    }

    /**
     * Sets the position of the employee within the organization.
     * @param positionInRc The position of the employee within the organization.
     */
    public void setPositionInRc(String positionInRc) {
        this.positionInRc = positionInRc;
    }

    /**
     * Retrieves the date when the employee was employed.
     * @return The date when the employee was employed.
     */
    public Timestamp getDateEmployed() {
        return dateEmployed;
    }

    /**
     * Sets the date when the employee was employed.
     * @param dateEmployed The date when the employee was employed.
     */
    public void setDateEmployed(Timestamp dateEmployed) {
        this.dateEmployed = dateEmployed;
    }

    /**
     * Retrieves the birthdate of the employee.
     * @return The birthdate of the employee.
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * Sets the birthdate of the employee.
     * @param birthdate The birthdate of the employee.
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Retrieves the birthplace of the employee.
     * @return The birthplace of the employee.
     */
    public String getBirthplace() {
        return birthplace;
    }

    /**
     * Sets the birthplace of the employee.
     * @param birthplace The birthplace of the employee.
     */
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    /**
     * Retrieves the sex of the employee.
     * @return The sex of the employee.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the employee.
     * @param sex The sex of the employee.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Retrieves the civil status of the employee.
     * @return The civil status of the employee.
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * Sets the civil status of the employee.
     * @param civilStatus The civil status of the employee.
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * Retrieves the citizenship of the employee.
     * @return The citizenship of the employee.
     */
    public String getCitizenship() {
        return citizenship;
    }

    /**
     * Sets the citizenship of the employee.
     * @param citizenship The citizenship of the employee.
     */
    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    /**
     * Retrieves the religion of the employee.
     * @return The religion of the employee.
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Sets the religion of the employee.
     * @param religion The religion of the employee.
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * Retrieves the height of the employee.
     * @return The height of the employee.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the employee.
     * @param height The height of the employee.
     */
    public void setHeight(double height) {
        this.height = height;
    }


    /**
     * Retrieves the weight of the employee.
     * @return The weight of the employee.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the employee.
     * @param weight The weight of the employee.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Retrieves the email address of the employee.
     * @return The email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     * @param email The email address of the employee.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the Social Security System number of the employee.
     * @return The Social Security System number of the employee.
     */
    public String getSssNo() {
        return sssNo;
    }

    /**
     * Sets the Social Security System number of the employee.
     * @param sssNo The Social Security System number of the employee.
     */
    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    /**
     * Retrieves the Tax Identification Number of the employee.
     * @return The Tax Identification Number of the employee.
     */
    public String getTinNo() {
        return tinNo;
    }

    /**
     * Sets the Tax Identification Number of the employee.
     * @param tinNo The Tax Identification Number of the employee.
     */
    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * Retrieves the Pag-IBIG Fund number of the employee.
     * @return The Pag-IBIG Fund number of the employee.
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    /**
     * Sets the Pag-IBIG Fund number of the employee.
     * @param pagibigNo The Pag-IBIG Fund number of the employee.
     */
    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    /**
     * Retrieves the unique identifier of the employee.
     * @return The unique identifier of the employee.
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the unique identifier of the employee.
     * @param employeeId The unique identifier of the employee.
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}

