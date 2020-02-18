package by.tms.rest.controller;

import by.tms.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reg")
public class RegController {
     
     @Autowired
     private List<User> userList;
     
     @PostMapping
     public ResponseEntity<User> reg(@RequestBody User user) {
          if (userList.contains(user)) throw new RuntimeException();
          userList.add(user);
          return new ResponseEntity<>(user, HttpStatus.CREATED);
     }
     
     @GetMapping(path = "/users")
     public List<User> getUsers() {
          return userList;
     }
}
