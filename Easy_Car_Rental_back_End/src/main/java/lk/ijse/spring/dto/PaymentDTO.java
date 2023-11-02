package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PaymentDTO {
    private String paymentId;
    private String paymentDate;
    private String paymentTime;
    private String distance;
    private String waiverPaymentAmount;
    private String extraMileagePerKM;
    private String lossDamageWaiverPayment;
    private String waiverPaymentBalance;
    private String paymentStatus;
    private MultipartFile waiverPaymentBillFilePath;
}
