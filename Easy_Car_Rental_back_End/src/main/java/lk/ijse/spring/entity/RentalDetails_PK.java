package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalDetails_PK implements Serializable {
    private String RentRequestId;
    private String carRegistraionNumber;
}
