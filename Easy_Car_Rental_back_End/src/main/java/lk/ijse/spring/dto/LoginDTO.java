package lk.ijse.spring.dto;

import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LoginDTO {
    private String logInId;
    private LocalDate loginDate;
    private LocalTime loginTime;
    private User user;
}
