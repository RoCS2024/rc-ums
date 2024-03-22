package com.user.management.app.model.student;
/**
 * This is the Student Model.
 * */
public class Student {
    /**
     * This is the Student Field.
     * */
    private String studentId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String sex;
    private String birthday;
    private String religion;
    private String email;
    private String address;
    private String contactNumber;

    /**
     * This is the Student getter and setter.
     * */

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

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
