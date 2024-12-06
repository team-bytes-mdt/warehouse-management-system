package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.repositories.UserRepository;
import de.fhdo.warehouseMgmtSys.domain.User;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void addUser(User user) {
        this.userRepository.save(user);
    }

    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getUserId()).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setAddress(user.getAddress());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }
}
