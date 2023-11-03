package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Payment {
    @Id
    private String paymentId;
    private Date paymentDate;
    private Time paymentTime;
    private int distance;
    private Double waiverPaymentAmount;
    private Double extraMileagePerKM;
    private Double lossDamageWaiverPayment;
    private Double waiverPaymentBalance;
    private String paymentStatus;
    private String waiverPaymentBillFilePath;
}
