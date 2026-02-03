package com.example.demo.LoginController;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        boolean created = userService.registerUser(userDTO);
        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email already exists");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        boolean valid = userService.validateCredentials(email, password);
        if (valid) {
            String role = userService.getRoleByEmail(email);
            return ResponseEntity.ok("Login successful. Role: " + role);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordRequest request) {
        boolean updated = userService.updatePassword(request.getEmail(), request.getNewPassword());
        if (updated) {
            return ResponseEntity.ok("Password updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }


    @PutMapping("/approve")
    public ResponseEntity<String> approveMentor(@RequestBody ApproveMentorRequest request) {
        boolean approved = userService.approveMentor(request.getId());
        if (approved) {
            return ResponseEntity.ok("Mentor approved successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid mentor ID or role mismatch");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? ResponseEntity.ok("User deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
