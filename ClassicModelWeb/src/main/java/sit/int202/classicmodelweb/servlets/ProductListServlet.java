package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.repositories.ProductRepo;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/product-list")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepo productRepo = new ProductRepo();
        int defaultPageSize = productRepo.getDefaultPageSize();
        String pageParam = request.getParameter("page");
        String pageSizeParam = request.getParameter("pageSize");
        int page = pageParam == null ? 1 : Integer.parseInt(pageParam);
        int pageSize = pageSizeParam == null ? defaultPageSize : Integer.parseInt(pageSizeParam);
        int itemCount = productRepo.countAll();
        int totalPage = (itemCount / pageSize) + (itemCount % pageSize == 0 ? 0 : 1);
        List<Product> productList = productRepo.findAll(page, pageSize);
        request.setAttribute("products", productList);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("totalPage", totalPage);
        Cookie ck = new Cookie("lastpage", "product-list");
        ck.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(ck);
        getServletContext().getRequestDispatcher("/ProductList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
