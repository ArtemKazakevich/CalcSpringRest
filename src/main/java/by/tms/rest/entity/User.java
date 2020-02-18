package by.tms.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
     
     @JsonIgnore
     long id;
     String firstName;
     String lastName;
     String email;
     int password;
     
     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          User user = (User) o;
          return password == user.password &&
                  Objects.equals(email, user.email);
     }
     
     @Override
     public int hashCode() {
          return Objects.hash(email, password);
     }
}
