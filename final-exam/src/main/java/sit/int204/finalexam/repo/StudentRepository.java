package sit.int204.finalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalexam.entities.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}