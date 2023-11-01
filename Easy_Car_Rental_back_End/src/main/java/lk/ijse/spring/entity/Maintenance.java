package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Maintenance {
    @Id
    private String serviceId;
    private LocalDate serviceDate;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "carId",referencedColumnName = "carId",nullable = false)
    private Car carId;

    private int mileageAtService;
    private int nextServiceMileage;
    private String serviceStatus;
    private String serviceDetails;
    private Double serviceCost;
}
