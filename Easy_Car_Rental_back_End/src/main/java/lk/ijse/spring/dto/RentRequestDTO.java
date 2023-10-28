package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
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
public class RentRequestDTO {
    private String RentRequestId;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String rentStatus;
    private String rentStatusDescription;
    private Customer customer;
}
