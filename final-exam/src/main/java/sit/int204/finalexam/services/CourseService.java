package sit.int204.finalexam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.finalexam.entities.Course;
import sit.int204.finalexam.entities.CourseStudent;
import sit.int204.finalexam.repo.CourseRepository;

import java.util.Set;

@Service
public class CourseService {
    private final CourseRepository repo;

    @Autowired
    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Set<CourseStudent> getStudentsByCourseId(Integer id) {
        Course course = repo.findCourseByCourseId(id);
        return course.getStudents();
    }

    public Set<CourseStudent> getStudentsBySubjectCode(String subjectCode) {
        Course course = repo.findCourseBySubjectCode(subjectCode);
        return course.getStudents();
    }
}
