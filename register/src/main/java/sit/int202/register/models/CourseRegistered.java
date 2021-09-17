package sit.int202.register.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseRegistered {
    private Map<Integer, List<Subject>> registeredSubjects = new HashMap<>();

    public void registerSubject(int semester, Subject subject) {
        registeredSubjects.computeIfAbsent(semester, k -> new ArrayList<>());
        registeredSubjects.get(semester).add(subject);
    }

    public void removeAllRegisteredCourse(int semester) {
        registeredSubjects.remove(semester);
    }

    public void removeAllRegisteredCourse() {
        registeredSubjects.clear();
    }

    public List<Subject> getRegisteredCourse(int semester) {
        return registeredSubjects.get(semester);
    }

    public Map<Integer, List<Subject>> getHistory() {
        return this.registeredSubjects;
    }
}
