package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private int driverNicNumber;
    private String driverName;
    private String driverAddress;
    private String driverEmail;
    private int driverDrivingLicenseNumber;
    private int driverTelNumber;
    private String driverNicFrontFilePath;
    private String driverNicBackFilePath;
    private String driverDrivingLicenseFrontFilePath;
    private String driverDrivingLicenseBackFilePath;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
