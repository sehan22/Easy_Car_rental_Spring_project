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
public class CarDTO {
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
    private MultipartFile carFrontViewImgFilePath;
    private MultipartFile carBackViewImgFilePath;
    private MultipartFile carSideViewImgFilePath;
    private MultipartFile carInteriorViewImgFilePath;
}
