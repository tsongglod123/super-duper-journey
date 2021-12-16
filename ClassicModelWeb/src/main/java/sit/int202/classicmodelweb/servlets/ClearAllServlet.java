package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelCartItem;

import java.io.IOException;

@WebServlet(name = "ClearAllServlet", value = "/clear-all")
public class ClearAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart<String, ClassicModelCartItem> cart = (Cart) session.getAttribute("cart");
        cart.clear();
        response.getWriter().println(cart.countQuantity());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
