package sit.int202.practice.models;

import java.util.*;

public class CourseRepository {
    private final static String DATA_FILE = "data.txt";
    private static final Map<Integer, List<Subject>> courses = new HashMap();

    static {
        init();
    }

    public static List<Subject> getSubjects(int semester) {
        return courses.get(semester);
    }

    public static Subject getSubject(int semester, String subjectId) {
        for (Subject subject : courses.get(semester)) {
            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                return subject;
            }
        }
        return null;
    }

    public static void init() {
        Scanner sc = null;
        sc = new Scanner(CourseRepository.class.getClassLoader().getResourceAsStream("data.txt"), "utf-8");
        List<String[]> subjectList = new ArrayList();
        String[] dataLine = null;
        while (sc.hasNextLine()) {
            dataLine = sc.nextLine().split(",");
            int semester = Integer.parseInt(dataLine[0]);
            Subject subject = new Subject(dataLine[1], dataLine[2], Double.parseDouble(dataLine[3]));
            courses.computeIfAbsent(semester, k -> new ArrayList<>());
            courses.get(semester).add(subject);
        }
        sc.close();
    }

}