//package sit.int202.practice;
//
//import sit.int202.practice.models.CourseRepository;
//import sit.int202.practice.models.Semester;
//import sit.int202.practice.models.Subject;
//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        List<String> semesters = new ArrayList<>();
//        for (String s : Semester.getAllSemesterText()) {
//            if (s != null) {
//                semesters.add(s);
//            }
//        }
//        Map<String, List<Subject>> allSubjects = new TreeMap<>();
//        for (int i = 0; i < semesters.size(); i++) {
//            allSubjects.put(semesters.get(i), CourseRepository.getSubjects(i + 1));
//        }
//        System.out.println(allSubjects);
//    }
//}
