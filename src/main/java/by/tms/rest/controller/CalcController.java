package by.tms.rest.controller;

import by.tms.rest.entity.RequestDTO;
import by.tms.rest.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/calc")
public class CalcController {
     
     @Autowired
     private Map<String, String> history;
     
     @Autowired
     private List<Long> tokens;
     
     @PostMapping
     public double calc(@RequestBody CalcService calcService) {
          
          double result = calcService.action();
          history.put("history", LocalDateTime.now() + " - result = " + result);
          
          return result;
     }
}
