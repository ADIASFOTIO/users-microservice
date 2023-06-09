package com.usersmicroservice.usersmicroservice.repository;

import com.usersmicroservice.usersmicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
