package sit.int204.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sit.int204.demo.entities.Student;
import sit.int204.demo.repo.StudentRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentRepo repo;

    @GetMapping("/initialize")
    public ResponseEntity<String> init() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1001, "Somchai", 3.20));
        studentList.add(new Student(1002, "Somsak", 3.50));
        studentList.add(new Student(1003, "Somsri", 2.50));
        studentList.add(new Student(1004, "Somkiat", 3.75));
        studentList.add(new Student(1005, "Somchoke", 2.80));
        repo.saveAllAndFlush(studentList);
        String message = studentList.size() + " new students have added!";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/student-list")
    public ResponseEntity<String> getStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student student : repo.findAll()) {
            sb.append(student.getId()).append(", ").append(student.getName());
            sb.append(", ").append(student.getGpax());
            sb.append("<br>------------------------<br>");
        }
        return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", repo.findAll());
        return "student-list";
    }
}
