package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelCartItem;
import sit.int202.classicmodelweb.repositories.ProductRepo;

import java.io.IOException;

@WebServlet(name = "RemoveItemServlet", value = "/remove-item")
public class RemoveItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelCartItem> cart = (Cart) session.getAttribute("cart");
        ProductRepo productRepo = new ProductRepo();
        Product product = productRepo.findProduct(productCode);
        if (product != null) {
            cart.removeItem(productCode);
        }
        response.getWriter().println(cart.countQuantity());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
