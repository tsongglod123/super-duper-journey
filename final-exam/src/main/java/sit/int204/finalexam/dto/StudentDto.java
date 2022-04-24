package sit.int204.finalexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int204.finalexam.entities.CourseStudent;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Integer studentId;
    private String name;
    private Set<CourseStudent> courses = new LinkedHashSet<>();
}
