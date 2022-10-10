package com.inside.user;

import org.apache.logging.log4j.Logger;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api")
public class MainController {

    private static final Logger LOGGER =  LogManager.getLogger( MainController.class );

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping(path="/user")
    public @ResponseBody User addNewUser (@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CrossOrigin
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
      Optional<User> userData = userRepository.findById(id);
  
      if (userData.isPresent()) {
        return new ResponseEntity<>(userData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
}
