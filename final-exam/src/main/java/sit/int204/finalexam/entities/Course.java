package sit.int204.finalexam.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "course_id", nullable = false)
    private Integer courseId;

    @Column(name = "subject_code", nullable = false, length = 50)
    private String subjectCode;

    @OneToMany(mappedBy = "course")
    private Set<CourseStudent> students = new LinkedHashSet<>();

    @OneToOne(targetEntity = Subject.class)
    @JoinColumn(name = "subject_code", insertable = false, updatable = false)
    private Subject subject;

}