package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Car;
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
public class ServiceDTO {
    private String serviceId;
    private LocalDate serviceDate;
    private LocalTime serviceTime;
    private String serviceDetails;
    private int mileageAtService;
    private int nextServiceMileage;
    private Double serviceCost;
    private String serviceStatus;
    private Car car;
}
