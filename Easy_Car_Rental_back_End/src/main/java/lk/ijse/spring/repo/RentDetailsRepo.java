package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentDetailsRepo extends JpaRepository<RentDetails, String> {
}
