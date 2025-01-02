package de.fhdo.warehouseMgmtSys.service;

import de.fhdo.warehouseMgmtSys.repositories.UserRepository;
import de.fhdo.warehouseMgmtSys.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Optional<User> getUserByUsername(long id) {
        return userRepository.findById(id);
    }

    public void createUser(User user) {
        this.userRepository.save(user);
    }


    public boolean deleteUser(long id) {

        return false;
    }
}
