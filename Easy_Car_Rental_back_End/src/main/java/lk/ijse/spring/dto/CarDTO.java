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
    private String carRegistraionNumber;
    private String carBrand;
    private String carTone;
    private String transmissionType;
    private String carType;
    private String fuelType;
    private int numberOfPassengers;
    private int freeMileageForPrice;
    private int currentMileage;
    private Double waiverPaymentAmount;
    private Double priceForExtraKM;
    private Double priceForDailyRent;
    private Double priceForMonthlyRent;
    private MultipartFile carFrontViewImgFilePath;
    private MultipartFile carBackViewImgFilePath;
    private MultipartFile carSideViewImgFilePath;
    private MultipartFile carInteriorViewImgFilePath;
}
