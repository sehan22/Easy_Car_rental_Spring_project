package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, String> {
}
