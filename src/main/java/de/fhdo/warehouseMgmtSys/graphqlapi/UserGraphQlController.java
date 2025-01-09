package de.fhdo.warehouseMgmtSys.graphqlapi;

import de.fhdo.warehouseMgmtSys.domain.User;
import de.fhdo.warehouseMgmtSys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import java.util.List;

@Controller
public class UserGraphQlController {

    private final UserService userService;

    @Autowired
    public UserGraphQlController(UserService userService) {
        this.userService = userService;
    }

    // Query to fetch all users
    @QueryMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    // Query to fetch a user by ID
    @QueryMapping
    public User user(@Argument Long userId) {
        return userService.getUserById(userId).orElse(null);
    }

    // Mutation to create a new user
    @MutationMapping
    public User createUser(@Argument User user) {
        return userService.createUser(user);
    }

    // Mutation to update an existing user
    @MutationMapping
    public User updateUser(@Argument Long userId, @Argument User user) {
        return userService.updateUser(userId, user).orElse(null);
    }

    // Mutation to delete a user by ID
    @MutationMapping
    public Boolean deleteUser(@Argument Long userId) {
        return userService.deleteUser(userId);
    }
}
