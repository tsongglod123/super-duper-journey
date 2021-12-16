package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Customer;

import java.io.IOException;

@WebServlet(name = "AdminP2Servlet", value = "/042/admin/page2")
public class AdminP2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Customer user = (Customer) session.getAttribute("user");
            request.setAttribute("firstname", user.getContactFirstName());
            request.setAttribute("lastname", user.getContactLastName());
            request.setAttribute("role", user.getRole());
        } else if (session.getAttribute("admin") != null) {
            Customer admin = (Customer) session.getAttribute("admin");
            request.setAttribute("firstname", admin.getContactFirstName());
            request.setAttribute("lastname", admin.getContactLastName());
            request.setAttribute("role", admin.getRole());
        } else if (session.getAttribute("guest") != null) {
            Customer guest = (Customer) session.getAttribute("guest");
            request.setAttribute("firstname", guest.getContactFirstName());
            request.setAttribute("lastname", guest.getContactLastName());
            request.setAttribute("role", guest.getRole());
        }
        getServletContext().getRequestDispatcher("/042/admin/page2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
