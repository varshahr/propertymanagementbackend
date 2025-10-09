package com.property.property.management.repository;

import com.property.property.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    // Add this method to support email uniqueness check
    User findByEmail(String email);
}
