package sit.int204.finalpractice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalpractice.entities.Office;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, String> {
    List<Office> findAllByCountryEquals(String country);
}