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
public class CustomerIngDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusEmail;
    private String cusNicNumber;
    private String cusDrivingLicenseNumber;
    private String cusTelNumber;
    private String cusNicFrontFilePath;
    private String cusDrivingLicenseFrontFilePath;
    private UserDTO user;
}
