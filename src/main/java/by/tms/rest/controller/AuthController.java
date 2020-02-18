package by.tms.rest.controller;

import by.tms.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
     
     @Autowired
     private List<User> userList;
     
     @Autowired
     private List<Long> tokens;
     
     @PostMapping
     public ResponseEntity<Integer> auth(@RequestBody User user) {
          long i = 0;
          if (userList.contains(user)) {
               i = new Random().nextLong();
               tokens.add(i);
               return new ResponseEntity(i, HttpStatus.OK);
          }
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }
}
