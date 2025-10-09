package com.property.property.management.Controller;

import com.property.property.management.model.User;
import com.property.property.management.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173") // React dev server
public class UserController {

    private final UserRepository repo;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        logger.info("Login attempt for username: {}", user.getUsername());
        User u = repo.findByUsername(user.getUsername());
        if(u != null && u.getPassword().equals(user.getPassword())) {
            logger.info("Login successful for username: {}", user.getUsername());
            return ResponseEntity.ok("Login Successful");
        }
        logger.warn("Invalid login attempt for username: {}", user.getUsername());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }

    // Optional: register new user
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        logger.info("Registering new user: {}", user.getUsername());
        User savedUser = repo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
