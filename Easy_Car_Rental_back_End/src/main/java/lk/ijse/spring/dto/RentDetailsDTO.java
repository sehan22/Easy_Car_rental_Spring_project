package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentDetailsDTO {
    private String rentRequestId;
    private String carId;
    private String driverId;
    private PaymentDTO payment;
}
