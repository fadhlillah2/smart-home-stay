package com.komodo.serviceone.controller;

import com.komodo.serviceone.entity.User;
import com.komodo.serviceone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("")
    public User createEmployee(@Valid @RequestBody User newUser) {
        return service.saveEmployee(newUser);
    }

    @GetMapping("")
    public List<User> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {
        User user = service.getEmployeeById(employeeId);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                               @Valid @RequestBody User userDetails) throws Exception {
        User updatedUser = service.updateEmployee(employeeId, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws Exception {
        service.deleteEmployee(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        return service.registerUser(user);
    }



}
