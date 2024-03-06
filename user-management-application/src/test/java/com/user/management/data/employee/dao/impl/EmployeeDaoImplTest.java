package com.user.management.data.employee.dao.impl;

import com.user.management.app.model.employee.Employee;
import com.user.management.data.connection.ConnectionHelper;
import com.user.management.data.employee.dao.EmployeeDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {

    private static EmployeeDao employeeDao;

    @BeforeAll
    static void setUp() {
        employeeDao = new EmployeeDaoImpl();
    }

    @Test
    void saveEmployee_ValidEmployee_ReturnsEmployeeWithId() {
        Employee testEmployee = new Employee();
        testEmployee.setLastName("Magnaye");
        testEmployee.setFirstName("Justine");
        testEmployee.setMiddleName("Dave");
        testEmployee.setPositionInRc("Manager");
        testEmployee.setDateEmployed(new Timestamp(System.currentTimeMillis()));
        testEmployee.setBirthdate("2000-01-01");
        testEmployee.setBirthplace("Silang");
        testEmployee.setSex("Male");
        testEmployee.setCivilStatus("Single");
        testEmployee.setCitizenship("Filipino");
        testEmployee.setReligion("Christian");
        testEmployee.setHeight(175.5);
        testEmployee.setWeight(70.2);
        testEmployee.setEmail("JustineMagnaye@example.com");
        testEmployee.setSssNo("123-456-789");
        testEmployee.setTinNo("987-654-321");
        testEmployee.setPagibigNo("ABC-123");
        testEmployee.setEmployeeNo("EMP0001");

        try {
            Employee savedEmployee = employeeDao.saveEmployee(testEmployee);

            assertNotNull(savedEmployee.getEmployeeNo());
            assertEquals(testEmployee.getLastName(), savedEmployee.getLastName());
            assertEquals(testEmployee.getFirstName(), savedEmployee.getFirstName());
            assertEquals(testEmployee.getMiddleName(), savedEmployee.getMiddleName());
            assertEquals(testEmployee.getPositionInRc(), savedEmployee.getPositionInRc());
            assertEquals(testEmployee.getDateEmployed(), savedEmployee.getDateEmployed());
            assertEquals(testEmployee.getBirthdate(), savedEmployee.getBirthdate());
            assertEquals(testEmployee.getBirthplace(), savedEmployee.getBirthplace());
            assertEquals(testEmployee.getSex(), savedEmployee.getSex());
            assertEquals(testEmployee.getCivilStatus(), savedEmployee.getCivilStatus());
            assertEquals(testEmployee.getCitizenship(), savedEmployee.getCitizenship());
            assertEquals(testEmployee.getReligion(), savedEmployee.getReligion());
            assertEquals(testEmployee.getHeight(), savedEmployee.getHeight());
            assertEquals(testEmployee.getWeight(), savedEmployee.getWeight());
            assertEquals(testEmployee.getEmail(), savedEmployee.getEmail());
            assertEquals(testEmployee.getSssNo(), savedEmployee.getSssNo());
            assertEquals(testEmployee.getTinNo(), savedEmployee.getTinNo());
            assertEquals(testEmployee.getPagibigNo(), savedEmployee.getPagibigNo());
            assertEquals(testEmployee.getEmployeeNo(), savedEmployee.getEmployeeNo());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void checkEmployeeId_ValidEmployeeId_ReturnsEmployee() {
        String employeeId = "EMP0002";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO EMPLOYEE (employee_no, last_name, first_name, middle_name, position_in_rc, birthplace, sex, civil_status, citizenship, religion, height, weight, email, sss_no, tin_no, pagibig_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, "Magnaye");
            preparedStatement.setString(3, "Justine");
            preparedStatement.setString(4, "Dave");
            preparedStatement.setString(5, "Supervisor");
            preparedStatement.setString(6, "Silang");
            preparedStatement.setString(7, "Male");
            preparedStatement.setString(8, "Single");
            preparedStatement.setString(9, "Filipino");
            preparedStatement.setString(10, "Christian");
            preparedStatement.setDouble(11, 165.8);
            preparedStatement.setDouble(12, 55.9);
            preparedStatement.setString(13, "janeMagnaye@example.com");
            preparedStatement.setString(14, "987-654-321");
            preparedStatement.setString(15, "123-456-789");
            preparedStatement.setString(16, "XYZ-789");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            fail("Error inserting test data: " + e.getMessage());
        }

        try {
            Employee retrievedEmployee = employeeDao.checkEmployeeId(employeeId);

            assertNotNull(retrievedEmployee);
            assertEquals(employeeId, retrievedEmployee.getEmployeeNo());
            assertEquals("Magnaye", retrievedEmployee.getLastName());
            assertEquals("Justine", retrievedEmployee.getFirstName());
            assertEquals("Dave", retrievedEmployee.getMiddleName());
            assertEquals("Supervisor", retrievedEmployee.getPositionInRc());
            assertEquals("Silang", retrievedEmployee.getBirthplace());
            assertEquals("Male", retrievedEmployee.getSex());
            assertEquals("Single", retrievedEmployee.getCivilStatus());
            assertEquals("Filipino", retrievedEmployee.getCitizenship());
            assertEquals("Christian", retrievedEmployee.getReligion());
            assertEquals(166.0, retrievedEmployee.getHeight());
            assertEquals(56.0, retrievedEmployee.getWeight());
            assertEquals("janeMagnaye@example.com", retrievedEmployee.getEmail());
            assertEquals("987-654-321", retrievedEmployee.getSssNo());
            assertEquals("123-456-789", retrievedEmployee.getTinNo());
            assertEquals("XYZ-789", retrievedEmployee.getPagibigNo());
        } catch (SQLException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
