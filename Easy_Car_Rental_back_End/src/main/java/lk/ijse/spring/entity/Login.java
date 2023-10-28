package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Login {
    @Id
    private String logInId;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
//    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
    private User user;

    private LocalDate loginDate;
    private LocalTime loginTime;
}
