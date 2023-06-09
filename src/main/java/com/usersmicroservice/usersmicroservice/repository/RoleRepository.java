package com.usersmicroservice.usersmicroservice.repository;

import com.usersmicroservice.usersmicroservice.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);

}
