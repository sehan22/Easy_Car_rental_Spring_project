package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerImgDTO {
    private MultipartFile cusNicFrontFilePath;
    private MultipartFile cusNicBackFilePath;
    private MultipartFile cusDrivingLicenseFrontFilePath;
    private MultipartFile cusDrivingLicenseBackFilePath;
}
