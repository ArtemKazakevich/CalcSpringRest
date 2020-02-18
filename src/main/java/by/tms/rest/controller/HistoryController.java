package by.tms.rest.controller;

import by.tms.rest.entity.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
     private Map<String, String> history;
     
     @Autowired
     private List<Long> tokens;
     
     @GetMapping
     public Map<String, String> outputResult(@RequestBody RequestDTO requestDTO) {
          if (!tokens.contains(requestDTO.getToken())) throw new RuntimeException();

          return history;
     }
}
