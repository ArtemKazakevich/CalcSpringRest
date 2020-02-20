package by.tms.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalcService {
     
     @Autowired
     private Calculation calculation;
     
     public double action(String operation, int a, int b) {
          double value1 = a;
          double value2 = b;
          double result = 0;
          
          switch (operation) {
               case "sum":
                    result = calculation.sumOperation(value1, value2);
                    break;
               case "sub":
                    result = calculation.subOperation(value1, value2);
                    break;
               case "mult":
                    result = calculation.multOperation(value1, value2);
                    break;
               case "div":
                    result = calculation.divOperation(value1, value2);
                    break;
          }
          return result;
     }
}
