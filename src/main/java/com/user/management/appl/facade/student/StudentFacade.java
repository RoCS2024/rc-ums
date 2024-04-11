package com.user.management.appl.facade.student;


import com.user.management.appl.model.student.Student;

import java.sql.SQLException;
/**
 * This is the interface to the Student Facade
 */
public interface StudentFacade {

    /**
     * This finds a student by their ID.
     *
     * @param studentId is the student ID to find in the database.
     * @return student ID from the database
     */
    Student findStudentById(String studentId);

    /**
     * This finds a student by their email.
     *
     * @param studentEmail is the student email to find in the database.
     * @return student email from the database
     */
    Student findStudentByEmail(String studentEmail);

    /**
     * This saves a new student in the database.
     *
     * @param student is the student to be saved.
     * @return True if the student was successfully saved.
     */
    boolean saveStudent(Student student);

}