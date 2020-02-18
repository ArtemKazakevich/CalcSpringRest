package by.tms.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
     
     @ExceptionHandler(RuntimeException.class)
     public ResponseEntity ex() {
          return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
     }
}