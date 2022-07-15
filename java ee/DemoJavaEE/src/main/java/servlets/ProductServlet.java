package servlets;

import demo.javaee.demojavaee.models.Product;
import demo.javaee.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();

    @Override
    public void init() throws ServletException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null){
            response.sendRedirect(request.getContextPath() + "/product/getAll.jsp"); // redirects to the product list page
        }
        else {
            response.sendRedirect(request.getContextPath() + "/product/getOne.jsp?id=" + id); // redirects to the product page
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
