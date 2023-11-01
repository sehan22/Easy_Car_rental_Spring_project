package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MaintenanceDTO {
    private String serviceId;
    private String serviceDate;
    private CarDTO car;
    private String mileageAtService;
    private String nextServiceMileage;
    private String serviceStatus;
    private String serviceDetails;
    private Double serviceCost;
}
