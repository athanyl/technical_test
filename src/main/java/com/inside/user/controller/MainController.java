package com.inside.user.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inside.user.exception.ResourceNotFoundException;
import com.inside.user.model.User;
import com.inside.user.repository.UserRepository;

@RestController
@RequestMapping(path="/api")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping(path="/user")
    public @ResponseStatus User addNewUser (@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) 
      throws ResourceNotFoundException {
        User user = userRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        return ResponseEntity.ok().body(user);
    }
}
