package sit.int204.classicmodelsservice.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subject_code", nullable = false, length = 50)
    private String subjectCode;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "credit")
    private Double credit;
}