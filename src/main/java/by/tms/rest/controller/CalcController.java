package by.tms.rest.controller;

import by.tms.rest.model.CalcRequest;
import by.tms.rest.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/calc")
public class CalcController {
     
     @Autowired
     private Map<String, Double> history;
     
     @Autowired
     private List<Long> tokens;
     
     @Autowired
     CalcService calcService;
     
     @PostMapping
     public ResponseEntity<Double> calc(@RequestBody CalcRequest calcRequest) {
          if (!tokens.contains(calcRequest.getToken())) throw new RuntimeException();
          
          double result = calcService.action(calcRequest.getOperation(), calcRequest.getA(), calcRequest.getB());
          history.put(LocalDateTime.now() + " - result = ", result);
          
          return new ResponseEntity<>(result, HttpStatus.OK);
     }
}
