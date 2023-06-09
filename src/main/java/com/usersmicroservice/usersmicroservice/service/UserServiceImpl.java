package com.usersmicroservice.usersmicroservice.service;

import com.usersmicroservice.usersmicroservice.entities.Role;
import com.usersmicroservice.usersmicroservice.entities.User;
import com.usersmicroservice.usersmicroservice.repository.RoleRepository;
import com.usersmicroservice.usersmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// permette di inserire nella DB direttamente
@Transactional
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(rolename);
        user.getRoles().add(role);
        //userRepository.save(user);
        return user;
    }
}
