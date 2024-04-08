package com.user.management.appl.model.student;
/**
 * POJO class for Employee. This class represents the User Management Employee.
 * */
public class Student {

    /** A unique id of the Student. */
    private String studentId;

    /** The last name of the Student. */
    private String lastName;

    /** The first name of the Student. */
    private String firstName;

    /** The middle name of the Student. */
    private String middleName;

    /** The gender of the Student. */
    private String sex;

    /** The birthday of the Student. */
    private String birthday;

    /** The religion of the Student. */
    private String religion;

    /** The email of the Student. */
    private String email;

    /** The address of the Student. */
    private String address;

    /** The contact number of the Student. */
    private String contactNumber;

    /**
     * This is the Student getter and setter.
     * */


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
     * @return The birthday of the student.
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday of the student.
     * @param birthday The birthday of the student.
     */
    public void setBirthday(String birthday) {
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



    /**
     * Checks if a given birthday string is in a valid format (MM/DD/YYYY).
     * @param birthday The birthday string to validate.
     * @return True if the birthday string is in a valid format, false otherwise.
     */
    public static boolean isValidBirthday(String birthday) {
        try {
            String[] parts = birthday.split("/");
            if (parts.length != 3)
                return false;

            int month, day, year;
            try {
                month = Integer.parseInt(parts[0]);
                day = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                return false;
            }

            if (month < 1 || month > 12)
                return false;

            if (day < 1 || day > 31)
                return false;

            if (year < 1950 || year > 2100)
                return false;

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
