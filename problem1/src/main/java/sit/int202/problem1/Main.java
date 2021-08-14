package sit.int202.problem1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Student> hashSet = new HashSet<>();
        hashSet.add(new Student(10001, "Somsri", 3.25f));
        hashSet.add(new Student(10002, "Somsak", 3.00f));
        hashSet.add(new Student(10009, "Somchai", 3.26f));
        hashSet.add(new Student(10007, "Somsiri", 3.25f));
        hashSet.add(new Student(10037, "Sirisopaphan", 3.25f));
        Set<Student> temp = new HashSet<>(hashSet);

        //cannot order HashSet directly, convert into List
        List<Student> list = new ArrayList<>(temp);
        list.sort(Student.STUDENT_COMPARATOR_GPAX);
        System.out.println(list);

        Set<Student> treeSet = new TreeSet<>(Student.STUDENT_COMPARATOR_GPAX);
        treeSet.addAll(hashSet);
        System.out.println(treeSet);
    }
}
