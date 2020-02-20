package by.tms.rest.controller;

import by.tms.rest.model.RequestDTO;
import by.tms.rest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(path = "/user")
public class UserController {
     
     @Autowired
     private List<User> userList;
     
     @Autowired
     private List<Long> tokens;
     
     @PostMapping(path = "/reg")
     public ResponseEntity<User> reg(@RequestBody User user) {
          if (userList.contains(user)) throw new RuntimeException();
          userList.add(user);
          return new ResponseEntity<>(user, HttpStatus.CREATED);
     }
     
     @PostMapping(path = "/auth")
     public ResponseEntity<Integer> auth(@RequestBody User user) {
          long i = 0;
          if (userList.contains(user)) {
               i = new Random().nextLong();
               tokens.add(i);
               return new ResponseEntity(i, HttpStatus.OK);
          }
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
     }
     
     @GetMapping(path = "/logout")
     public ResponseEntity<String> logout(@RequestBody RequestDTO requestDTO) {
          if (!tokens.contains(requestDTO.getToken())) throw new RuntimeException();
          
          long token = requestDTO.getToken();
          int i = tokens.indexOf(token);
          tokens.remove(i);
          
          return new ResponseEntity<>("You're out", HttpStatus.OK);
     }
     
     @GetMapping(path = "/listUser")
     public ResponseEntity<List<User>> getUsers(@RequestBody RequestDTO requestDTO) {
          if (!tokens.contains(requestDTO.getToken())) throw new RuntimeException();
          return new ResponseEntity<>(userList, HttpStatus.CREATED);
     }
}
