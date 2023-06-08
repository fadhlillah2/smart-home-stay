//package com.komodo.cimplecrud.service;
//
//import com.komodo.cimplecrud.entity.Employee;
//import com.komodo.cimplecrud.repository.EmployeeRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class EmployeeServiceTest {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @MockBean
//    private EmployeeRepository employeeRepository;
//
//    @BeforeEach
//    public void setUp() {
//        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setName("John Doe");
//        employee.setRole("Developer");
//
//        when(employeeRepository.findById(1L))
//                .thenReturn(Optional.of(employee));
//
//        when(employeeRepository.save(employee))
//                .thenReturn(employee);
//
//        when(employeeRepository.findAll())
//                .thenReturn(Arrays.asList(employee));
//    }
//
//    @Test
//    public void whenValidId_thenEmployeeShouldBeFound() {
//        try {
//            Employee found = employeeService.getEmployeeById(1L);
//            assertEquals(found.getName(), "John Doe");
//            assertEquals(found.getRole(), "Developer");
//        } catch (Exception e) {
//            fail("Exception should not have been thrown.");
//        }
//    }
//
//    @Test
//    public void whenNonexistentId_thenExceptionShouldBeThrown() {
//        Long nonexistentId = 2L;
//        Exception exception = assertThrows(Exception.class, () -> {
//            employeeService.getEmployeeById(nonexistentId);
//        });
//
//        assertEquals("Employee not found with id: " + nonexistentId, exception.getMessage());
//    }
//
//    @Test
//    public void whenSaveEmployee_thenEmployeeShouldBeReturned() {
//        Employee toSave = new Employee();
//        toSave.setName("John Doe");
//        toSave.setRole("Developer");
//
//        try {
//            Employee saved = employeeService.saveEmployee(toSave);
//            assertEquals(saved.getName(), "John Doe");
//            assertEquals(saved.getRole(), "Developer");
//        } catch (Exception e) {
//            fail("Exception should not have been thrown.");
//        }
//    }
//
//    // Continue testing all methods in the EmployeeService class
//}
