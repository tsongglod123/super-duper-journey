package sit.int204.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.demo.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
