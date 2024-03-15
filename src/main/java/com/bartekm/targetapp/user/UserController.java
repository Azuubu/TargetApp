package com.bartekm.targetapp.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping(path = "/us")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String welcome() {
        return "HOME PAGE for the target app";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
       return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")int id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setId(userService.getAllUsers().size() + 1);
        return ResponseEntity.created(getLocation(user.getId())).body(userService.createUser(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id")int id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
    // put requires a full set of data, including the changes, and patch requires only the changed data, without the rest

    private URI getLocation(int id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }

}
