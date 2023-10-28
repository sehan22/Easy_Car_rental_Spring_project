package lk.ijse.spring.repo;

import lk.ijse.spring.entity.RentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRequestRepo extends JpaRepository<RentRequest, String> {
}
