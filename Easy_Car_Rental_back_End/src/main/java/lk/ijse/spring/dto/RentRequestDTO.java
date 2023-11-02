package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.RentDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentRequestDTO {
    private String rentRequestId;
    private String pickUpTime;
    private String pickUpDate;
    private String returnDate;
    private String rentStatus;
    private String cusId;
    private List<RentDetailsDTO> rentDetails;
}
