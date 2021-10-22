package sit.int202.practice.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.practice.models.CourseRepository;
import sit.int202.practice.models.Semester;
import sit.int202.practice.models.Subject;

import java.io.IOException;
import java.util.*;

@WebServlet(name = "SubjectServlet", value = "/subjects")
public class SubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> semesters = new ArrayList<>();
        for (String s : Semester.getAllSemesterText()) {
            if (s != null) {
                semesters.add(s);
            }
        }
        request.setAttribute("semesters", semesters);
        getServletContext().getRequestDispatcher("/all_subjects.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = String.valueOf(request.getParameter("semester").charAt(0));
        int selectedSemester = Integer.parseInt(temp);
        List<Subject> subjects = CourseRepository.getSubjects(selectedSemester + 1);
        List<String> semesters = new ArrayList<>();
        for (String s : Semester.getAllSemesterText()) {
            if (s != null) {
                semesters.add(s);
            }
        }
        request.setAttribute("selected", selectedSemester);
        request.setAttribute("semesters", semesters);
        request.setAttribute("subjects", subjects);
        getServletContext().getRequestDispatcher("/all_subjects.jsp").forward(request, response);
    }
}
