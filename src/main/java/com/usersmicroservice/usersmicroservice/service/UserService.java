package com.usersmicroservice.usersmicroservice.service;

import com.usersmicroservice.usersmicroservice.entities.Role;
import com.usersmicroservice.usersmicroservice.entities.User;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);

}
