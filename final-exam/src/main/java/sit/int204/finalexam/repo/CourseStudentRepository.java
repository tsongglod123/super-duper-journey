package sit.int204.finalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalexam.entities.CourseStudent;

import java.util.List;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, Integer> {
}