package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.entity.RentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailsDTO {
    private RentRequest rentRequestId;
    private Car carRegistraionNumber;
    private Payment paymentId;
    private Driver driverNicNumber;
}
