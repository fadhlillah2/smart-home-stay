package com.komodo.serviceone.controller;

import com.komodo.serviceone.entity.User;
import com.komodo.serviceone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/users")
    public User createEmployee(@Valid @RequestBody User newUser) {
        return service.saveEmployee(newUser);
    }

    @GetMapping("/users")
    public List<User> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {
        User user = service.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                               @Valid @RequestBody User userDetails) throws Exception {
        User updatedUser = service.updateEmployee(employeeId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
        service.deleteEmployee(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
