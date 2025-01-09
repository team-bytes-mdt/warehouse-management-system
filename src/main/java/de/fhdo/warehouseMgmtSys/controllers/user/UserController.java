package de.fhdo.warehouseMgmtSys.controllers.user;

import de.fhdo.warehouseMgmtSys.converters.UserConverter;
import de.fhdo.warehouseMgmtSys.domain.User;
import de.fhdo.warehouseMgmtSys.dto.UserDto;
import de.fhdo.warehouseMgmtSys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        // Fetch all Orders and convert them to DTOs
        List<UserDto> users = userService.getAllUsers()
                .stream()
                .map(UserConverter::toDto)
                .collect(Collectors.toList());

        // Add DTO to the model
        model.addAttribute("users", users);
        return "user/users";
    }

    @GetMapping("/{id}")
    public String getUserById(Model model, @PathVariable long id) {
        // Fetch item and convert it to DTO
        UserDto user = userService.getUserById(id)
                .map(UserConverter::toDto)
                .orElse(null);

        // Add DTO to the model
        model.addAttribute("user", user);
        return "user/user";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/create-user";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserDto userDto) {
        User user = UserConverter.toEntity(userDto);
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable long id) {
        UserDto user = userService.getUserById(id)
                .map(UserConverter::toDto)
                .orElse(null);
        model.addAttribute("user", user);
        return "user/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute UserDto userDto) {
        User user = UserConverter.toEntity(userDto);
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
