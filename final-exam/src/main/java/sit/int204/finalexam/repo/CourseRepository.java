package sit.int204.finalexam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.finalexam.entities.Course;
import sit.int204.finalexam.entities.CourseStudent;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseByCourseId(Integer id);

    Course findCourseBySubjectCode(String subjectCode);
}