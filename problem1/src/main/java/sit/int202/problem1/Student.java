package sit.int202.problem1;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "gpax")
public class Student {
    private Integer id;
    private String name;
    private Float gpax;

    public static final Comparator<Student> STUDENT_COMPARATOR_GPAX = (o1, o2) -> {
        if (!o1.getGpax().equals(o2.getGpax())) {
            return o2.getGpax().compareTo(o1.getGpax());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    };
}
