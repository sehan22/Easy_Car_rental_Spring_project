package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Customer {
    @Id
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

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
