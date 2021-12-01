package sit.int202.classicmodelweb.servlets;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Customer;
import sit.int202.classicmodelweb.repositories.CustomerRepo;

import java.io.IOException;

@WebServlet(name = "AuthenServlet", value = "/login")
public class AuthenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        if (username == null || username.trim().length() == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        CustomerRepo cr = new CustomerRepo();
        Customer customer = cr.findByName(username);
        if (customer == null) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else {
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), customer.getPassword());
            if (!result.verified || !result.validFormat) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            } else {
                request.getSession().setAttribute("user", customer);
            }
        }
    }
}
