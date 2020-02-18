package by.tms.rest.service;

import org.springframework.stereotype.Component;

@Component
public class Calculation {
     public double divOperation(Double a, Double b) {
          double result = a / b;
          return result;
     }
     
     public double multOperation(Double a, Double b) {
          double result = a * b;
          return result;
     }
     
     public double subOperation(Double a, Double b) {
          double result = a - b;
          return result;
     }
     
     public double sumOperation(Double a, Double b) {
          double result = a + b;
          return result;
     }
}
