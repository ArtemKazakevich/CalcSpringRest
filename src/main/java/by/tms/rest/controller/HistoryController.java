package by.tms.rest.controller;

import by.tms.rest.model.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/history")
public class HistoryController {
     
     @Autowired
     private Map<String, Double> history;
     
     @Autowired
     private List<Long> tokens;
     
     @GetMapping
     public ResponseEntity<Map<String, Double>> outputResult(@RequestBody RequestDTO requestDTO) {
          if (!tokens.contains(requestDTO.getToken())) throw new RuntimeException();

          return new ResponseEntity<>(history, HttpStatus.OK);
     }
}
