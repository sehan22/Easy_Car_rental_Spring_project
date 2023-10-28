package lk.ijse.spring.dto;

import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
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
    private User user;
}
