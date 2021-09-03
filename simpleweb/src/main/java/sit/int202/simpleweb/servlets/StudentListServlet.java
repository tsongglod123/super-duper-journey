package sit.int202.simpleweb.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.simpleweb.models.StudentRepository;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/student-list")
public class StudentListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StudentRepository studentRepository = new StudentRepository();
        request.setAttribute("students", studentRepository.all());
        getServletContext().getRequestDispatcher("/student_list.jsp").forward(request, response);
        return;
    }
}
