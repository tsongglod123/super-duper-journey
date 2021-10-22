package sit.int202.practice.models;

public class Semester {
    private static final String[] TITLE = {
            null, "S1/Y1", "S2/Y1", "S1/Y2"
            , "S2/Y2", "S1/Y3", "S2/Y3", "S1/Y4"
            , "S2/Y4", "WIL project"
    };

    public static String[] getAllSemesterText() {
        return TITLE;
    }

    public static String getSemesterText(int semesterNumber) {
        if (semesterNumber >= TITLE.length) {
            return null;
        }
        return TITLE[semesterNumber];
    }
}

