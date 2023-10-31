package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
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
public class Service {
    @Id
    private String serviceId;
    private LocalDate serviceDate;
    private LocalTime serviceTime;
    private String serviceDetails;
    private int mileageAtService;
    private int nextServiceMileage;
    private Double serviceCost;
    private String serviceStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;
}
