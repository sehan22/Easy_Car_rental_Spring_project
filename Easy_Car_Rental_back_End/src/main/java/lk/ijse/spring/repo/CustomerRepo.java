package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, String> {
    @Query(value = "SELECT * FROM Customer WHERE userName = ?", nativeQuery = true)
    Customer getCustomerByUser_UserName(String userName);
}
