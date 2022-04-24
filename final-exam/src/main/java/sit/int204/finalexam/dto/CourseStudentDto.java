package sit.int204.finalexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseStudentDto {
    private Integer id;
    private StudentDto student;
    private CourseDto course;
    private Double grade;
}
