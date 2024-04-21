package com.user.management.appl.model.student;

import java.sql.Timestamp;

/**
 * POJO class for Employee. This class represents the User Management Employee.
 * */
public class Student {

    private String studentId;

    private String lastName;

    private String firstName;

    private String middleName;

    private String sex;

    private Timestamp birthday;

    private String religion;

    private String email;

    private String address;

    private String contactNumber;


    /**
     * Retrieves the unique identifier of the student.
     * @return The unique identifier of the student.
     */
    public String getStudentId() {
        return studentId;
    }


    /**
     * Sets the unique identifier of the student.
     * @param studentId The unique identifier of the student.
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Retrieves the last name of the student.
     * @return The last name of the student.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     * @param lastName The last name of the student.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the first name of the student.
     * @return The first name of the student.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     * @param firstName The first name of the student.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the middle name of the student.
     * @return The middle name of the student.
     */
    public String getMiddleName() {
        return middleName;
    }


    /**
     * Sets the middle name of the student.
     * @param middleName The middle name of the student.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Retrieves the gender of the student.
     * @return The gender of the student.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the gender of the student.
     * @param sex The gender of the student.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Retrieves the birthday of the student.
     *
     * @return The birthday of the student.
     */
    public Timestamp getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the student.
     * @param birthday The birthday of the student.
     */
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    /**
     * Retrieves the religion of the student.
     * @return The religion of the student.
     */
    public String getReligion() {
        return religion;
    }

    /**
     * Sets the religion of the student.
     * @param religion The religion of the student.
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * Retrieves the email address of the student.
     * @return The email address of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     * @param email The email address of the student.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the address of the student.
     * @return The address of the student.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the student.
     * @param address The address of the student.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the contact number of the student.
     * @return The contact number of the student.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number of the student.
     * @param contactNumber The contact number of the student.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

}