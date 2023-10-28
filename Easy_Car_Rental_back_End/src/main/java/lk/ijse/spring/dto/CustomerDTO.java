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
public class CustomerDTO {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusEmail;
    private int cusNicNumber;
    private int cusDrivingLicenseNumber;
    private int cusTelNumber;
    private String cusNicFrontFilePath;
    private String cusNicBackFilePath;
    private String cusDrivingLicenseFrontFilePath;
    private String cusDrivingLicenseBackFilePath;
    private User user;
}
