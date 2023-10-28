package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(RentalDetails_PK.class)
public class RentDetails {
    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "rentRequestId", referencedColumnName = "RentRequestId", nullable = false)
    private RentRequest rentRequestId;

    @Id
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "carRegistraionNumber", referencedColumnName = "carRegistraionNumber", nullable = false)
    private Car carRegistraionNumber;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId", nullable = false)
    private Payment paymentId;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "driverNicNumber", referencedColumnName = "driverNicNumber", nullable = true)
    private Driver driverNicNumber;
}
