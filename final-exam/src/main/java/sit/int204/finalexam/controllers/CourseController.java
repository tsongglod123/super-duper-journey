package sit.int204.finalexam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.finalexam.entities.CourseStudent;
import sit.int204.finalexam.services.CourseService;

import java.util.Set;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/id/{id}/students")
    public Set<CourseStudent> getStudentsByCourseId(@PathVariable Integer id) {
        return service.getStudentsByCourseId(id);
    }

    @GetMapping("/code/{subjectCode}/students")
    public Set<CourseStudent> getStudentsBySubjectCode(@PathVariable String subjectCode) {
        return service.getStudentsBySubjectCode(subjectCode);
    }
}
