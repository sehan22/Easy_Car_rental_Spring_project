package lk.ijse.spring.dto;

import lk.ijse.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private String driverNicNumber;
    private String driverName;
    private String driverAddress;
    private String driverEmail;
    private String driverDrivingLicenseNumber;
    private String driverTelNumber;
    private String driverStatus;
    private MultipartFile driverNicFrontFilePath;
    private MultipartFile driverDrivingLicenseFrontFilePath;
    private UserDTO user;
}
