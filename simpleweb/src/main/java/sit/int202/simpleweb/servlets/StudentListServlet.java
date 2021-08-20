package sit.int202.simpleweb.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.simpleweb.models.Student;
import sit.int202.simpleweb.models.StudentRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/student-list")
public class StudentListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentRepository studentRepository = new StudentRepository();
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<body style='padding: 100px'>");
            out.println("<h3>Student List ::</h3><hr>");
            out.println("<table>");
            for (Student student : studentRepository.all()) {
                out.println("<tr><td>Id: </td> <td>" + student.getId() + "</td></tr>");
                out.println("<tr><td>Name: </td> <td>" + student.getName() + "</td></tr>");
                out.println("<tr><td>GPAX: </td> <td>" + student.getGpax() + "</td></tr>");
                out.println("<tr><td colspan='2'><hr></td></tr>");
            }
            out.println("</table>");
            out.println("<a href = 'index.jsp'> [BACK] </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
