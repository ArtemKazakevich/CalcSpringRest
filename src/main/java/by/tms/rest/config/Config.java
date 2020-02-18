package by.tms.rest.config;

import by.tms.rest.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class Config {
     
     @Bean
     public Map<String, String> history(){
          return new HashMap<>();
     }
     
     @Bean
     public List<User> userList() {
          return new ArrayList<>();
     }
     
     @Bean
     public List<Long> tokens() {
          return new ArrayList<>();
     }
}
