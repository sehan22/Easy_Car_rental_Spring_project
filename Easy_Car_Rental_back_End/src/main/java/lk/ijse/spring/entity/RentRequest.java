package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentRequest {
    @Id
    private String RentRequestId;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String rentStatus;
    private String rentStatusDescription;

    @ManyToOne
    private Customer customer;
}
