package de.fhdo.warehouseMgmtSys.controllers.user;

import de.fhdo.warehouseMgmtSys.converters.UserConverter;
import de.fhdo.warehouseMgmtSys.dto.UserDto;
import de.fhdo.warehouseMgmtSys.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;


    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // Get all inventories
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllInventory() {
        List<UserDto> userDtos = userService.getAllUsers()
                .stream().map(UserConverter::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(userDtos);
    }

    // Get inventory by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getInventoryById(@PathVariable Long id) {

        return userService.getUserByUsername(id)
                .map(UserConverter::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    // Create a new inventory
    @PostMapping
    public ResponseEntity<UserDto> createInventory(@RequestBody UserDto userDto) {
        var user = UserConverter.toEntity(userDto);
        var savedUser = userService.createUser(user);
        return new ResponseEntity<>(UserConverter.toDto(savedUser), HttpStatus.CREATED);

    }

    // Update an inventory
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateInventory(@PathVariable long id,
                                                   @RequestBody UserDto UserDto) {
        var user = UserConverter.toEntity(UserDto);
        var updatedUser = userService.updateUser(id, user);
        return updatedUser.map(value -> ResponseEntity.ok(UserConverter.toDto(value)))
                .orElse(ResponseEntity.notFound().build());

    }

    // Delete an inventory
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteInventory(@PathVariable long id) {
        if(userService.deleteUser(id)){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }




}
