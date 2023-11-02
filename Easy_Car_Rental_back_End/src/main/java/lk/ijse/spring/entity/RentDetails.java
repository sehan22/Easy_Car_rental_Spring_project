package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(RentalDetails_PK.class)
public class RentDetails implements Serializable {
    @Id
    private String rentRequestId;
    @Id
    private String carId;

    private String driverId;

    @OneToOne(cascade = {CascadeType.ALL})
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "rentRequestId",referencedColumnName = "rentRequestId",insertable = false,updatable = false)
    private RentRequest rentRequest;

    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverId",insertable = false, updatable = false)
    private Driver driver;
}
