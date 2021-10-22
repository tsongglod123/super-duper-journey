package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.repositories.OfficeRepo;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepo officeRepo = new OfficeRepo();
        request.setAttribute("offices", officeRepo.findAll());
        String id = request.getParameter("officeCode");
        if (id != null) {
            request.setAttribute("selectedOffice", officeRepo.find(id));
        }
        getServletContext().getRequestDispatcher("/OfficeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
