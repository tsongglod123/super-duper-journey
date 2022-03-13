package sit.int204.classicmodelsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Office;

public interface OfficeRepo extends JpaRepository<Office, String> {
}
