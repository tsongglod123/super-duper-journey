package sit.int202.simpleweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.simpleweb.models.Student;
import sit.int202.simpleweb.models.StudentRepository;

import java.io.IOException;

@WebServlet(name = "AddStudentServlet", value = "/add-student")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/student_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String gpax = request.getParameter("gpax");
        if (id == null || id.length() == 0 || name == null || name.trim().length() == 0 || gpax == null || gpax.length() == 0) {
            request.setAttribute("error_msg", "invalid: input all fields are required!");
            getServletContext().getRequestDispatcher("/student_form.jsp").forward(request, response);
            return;
        }
        Student student = new Student(Integer.valueOf(id), name, Double.valueOf(gpax));
        StudentRepository repository = new StudentRepository();
        repository.save(student);
        request.setAttribute("student", student);
        getServletContext().getRequestDispatcher("/show_student_info.jsp").forward(request, response);
        // getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
