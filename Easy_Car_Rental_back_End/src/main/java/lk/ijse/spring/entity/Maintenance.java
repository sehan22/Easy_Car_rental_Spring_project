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
    private String serviceDate;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "carId",referencedColumnName = "carId",nullable = false)
    private Car car;

    private String mileageAtService;
    private String nextServiceMileage;
    private String serviceStatus;
    private String serviceDetails;
    private String serviceCost;
}
