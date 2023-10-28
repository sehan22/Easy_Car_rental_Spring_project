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
    private LocalDate paymentDate;
    private LocalTime paymentTime;
    private int distance;
    private Double waiverPaymentAmount;
    private Double extraMileagePerKM;
    private Double lossDamageWaiverPayment;
    private Double waiverPaymentBalance;
    private String paymentStatus;
    private MultipartFile waiverPaymentBillFilePath;
}
