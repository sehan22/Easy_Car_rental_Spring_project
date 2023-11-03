package lk.ijse.spring.dto.meta;

import lk.ijse.spring.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class DriverImgDTO {
    private String driverId;
    private String driverNicNumber;
    private String driverName;
    private String driverAddress;
    private String driverEmail;
    private String driverDrivingLicenseNumber;
    private String driverTelNumber;
    private String driverStatus;
    private String driverNicFrontFilePath;
    private String driverDrivingLicenseFrontFilePath;
    private UserDTO user;
}
