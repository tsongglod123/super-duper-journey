package sit.int204.finalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalexam.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, String> {
}