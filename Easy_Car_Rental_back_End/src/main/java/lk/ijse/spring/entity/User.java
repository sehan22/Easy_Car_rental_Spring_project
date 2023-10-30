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

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class User {
    @Id
    private String userName;
    private String userPassword;
    private String userRole;
    private String status;

    /*
    SQL Query For Admin
    INSERT INTO User (userName, userPassword, userRole, status) VALUES ('admin', 'admin12345@', 'ADMIN', 'ACTIVE');
    */
}
