package servlets;

import demo.javaee.demojavaee.models.Product;
import demo.javaee.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/product/add")
public class AddProductServlet extends HttpServlet {
    private final ProductService service = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/product/addOne.jsp"); // redirects to the new product page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets parameters from the form in addOne.jsp
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));

        int id = service.addOne(new Product(name, brand, category, price)); // adds the new product to the list and gets its id automatically

        response.sendRedirect(request.getContextPath() + "/product/getOne.jsp?id=" + id); // redirects to the new product page
    }
}
