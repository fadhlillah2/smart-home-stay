package com.komodo.serviceone.service;

import com.komodo.serviceone.entity.User;
import com.komodo.serviceone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public User registerUser(User user) {
        User savedUser = repository.save(user);
        kafkaTemplate.send("user.register", "User registered with id " + savedUser.getId());
        return savedUser;
    }

    public User saveEmployee(User user) {
        return repository.save(user);
    }

    public List<User> getAllEmployees() {
        return repository.findAll();
    }

    public User getEmployeeById(Long id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception("Employee not found with id: " + id));
    }

    public User updateEmployee(Long id, User userDetails) throws Exception {
        User user = getEmployeeById(id);
        user.setName(userDetails.getName());
        user.setRole(userDetails.getRole());
        return repository.save(user);
    }

    public void deleteEmployee(Long id) throws Exception {
        User user = getEmployeeById(id);
        repository.delete(user);
    }
}
