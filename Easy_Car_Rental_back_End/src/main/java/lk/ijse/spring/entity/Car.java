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
    private String carFrontViewImgFilePath;
    private String carBackViewImgFilePath;
    private String carSideViewImgFilePath;
    private String carInteriorViewImgFilePath;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Service> services = new ArrayList<>();
}
