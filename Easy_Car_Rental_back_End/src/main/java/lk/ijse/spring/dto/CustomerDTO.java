package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {
    @Id
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusEmail;
    private String cusNicFrontFilePath;
}
