package sit.int204.classicmodelsservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}