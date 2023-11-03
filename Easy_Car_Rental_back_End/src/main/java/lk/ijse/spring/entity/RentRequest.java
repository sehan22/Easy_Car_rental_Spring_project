package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RentRequest {
    @Id
    private String rentRequestId;
    private String pickUpTime;
    private String pickUpDate;
    private String returnDate;
    private String rentStatus;

    @ManyToOne
    @JoinColumn(name = "cusId",referencedColumnName = "cusId",nullable = false)
    private Customer cusId;

    @OneToMany(mappedBy = "rentRequest", cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;
}
