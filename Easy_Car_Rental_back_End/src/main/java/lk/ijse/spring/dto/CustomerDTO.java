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
public class CustomerDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusEmail;
    private String cusNicNumber;
    private String cusDrivingLicenseNumber;
    private String cusTelNumber;
    private MultipartFile cusNicFrontFilePath;
    private MultipartFile cusNicBackFilePath;
    private MultipartFile cusDrivingLicenseFrontFilePath;
    private MultipartFile cusDrivingLicenseBackFilePath;
    private User user;
}
