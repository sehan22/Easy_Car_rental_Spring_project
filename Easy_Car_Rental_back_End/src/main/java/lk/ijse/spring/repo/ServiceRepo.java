package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, String> {
}
