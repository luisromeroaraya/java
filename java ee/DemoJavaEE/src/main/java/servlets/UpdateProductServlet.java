package servlets;

import demo.javaee.demojavaee.models.Product;
import demo.javaee.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProductServlet", value = "/product/update")
public class UpdateProductServlet extends HttpServlet {
    private final ProductService service  = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
        }
        catch (NumberFormatException e) {
            response.sendError(400, "invalid id");
        }
        Product product = service.getOne(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("/product/update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // gets parameters from the form in addOne.jsp
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        service.update(new Product(id, name, brand, category, price)); // sends the new product and updates it
        System.out.println("updating product: " + id);

        response.sendRedirect(request.getContextPath() + "/product/getOne.jsp?id=" + id); // redirects to the new product page
    }
}
