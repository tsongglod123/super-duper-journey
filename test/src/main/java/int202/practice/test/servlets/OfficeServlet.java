package int202.practice.test.servlets;

import int202.practice.test.repo.OfficeRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "OfficeServlet", value = "/office")
public class OfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie ck = new Cookie("currentContents", "office");
        ck.setMaxAge(7 * 24 * 60 * 60);
        OfficeRepo officeRepo = new OfficeRepo();
        request.setAttribute("offices", officeRepo.findAll());
        response.addCookie(ck);
        getServletContext().getRequestDispatcher("/officeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
