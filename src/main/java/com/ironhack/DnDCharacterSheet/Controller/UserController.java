package com.ironhack.DnDCharacterSheet.Controller;

import com.ironhack.DnDCharacterSheet.Domain.UserEntity;
import com.ironhack.DnDCharacterSheet.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PostMapping("/users/register")
    public UserEntity registerUser(@RequestBody UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User already exists");
        }
    }
}