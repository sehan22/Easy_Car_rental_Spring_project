package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    @Id
    private String carId;
    private String carBrand;
    private String carType;
    private String waiverPaymentAmount;
    private String carRegistraionNumber;
    private String transmissionType;
    private String numberOfPassengers;
    private String fuelType;
    private String carTone;
    private String priceForDailyRent;
    private String priceForMonthlyRent;
    private String freeMileageForPrice;
    private String priceForExtraKM;
    private String currentMileage;
    private String carStatus;
    private String carFrontViewImgFilePath;
    private String carBackViewImgFilePath;
    private String carSideViewImgFilePath;
    private String carInteriorViewImgFilePath;
}
