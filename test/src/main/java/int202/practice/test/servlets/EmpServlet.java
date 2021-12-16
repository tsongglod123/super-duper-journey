package int202.practice.test.servlets;

import int202.practice.test.entities.Employee;
import int202.practice.test.repo.EmpRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmpServlet", value = "/employee-list")
public class EmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpRepo empRepo = new EmpRepo();
        String officeCode = request.getParameter("officeCode");
        List<Employee> emp = empRepo.findByOfficeId(Integer.parseInt(officeCode));
        request.setAttribute("empList", emp);
        getServletContext().getRequestDispatcher("/empList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
