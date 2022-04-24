package sit.int204.finalexam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseDto {
    private Integer courseId;
    private String subjectCode;
    private SubjectDto subject;
    private Set<CourseStudentDto> students = new LinkedHashSet<>();
}
