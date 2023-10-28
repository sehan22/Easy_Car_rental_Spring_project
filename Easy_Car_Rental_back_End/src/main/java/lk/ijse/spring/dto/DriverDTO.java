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
    private int driverNicNumber;
    private String driverName;
    private String driverAddress;
    private String driverEmail;
    private int driverDrivingLicenseNumber;
    private int driverTelNumber;
    private MultipartFile driverNicFrontFilePath;
    private MultipartFile driverNicBackFilePath;
    private MultipartFile driverDrivingLicenseFrontFilePath;
    private MultipartFile driverDrivingLicenseBackFilePath;
    private User user;
}
