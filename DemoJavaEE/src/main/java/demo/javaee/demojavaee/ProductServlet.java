package demo.javaee.demojavaee;

import demo.javaee.demojavaee.models.Product;
import demo.javaee.demojavaee.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = ProductService.getInstance();

    @Override
    public void init() throws ServletException {}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null){
            getAll(response);
        }
        else {
            getOne(response, Integer.parseInt(id));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void getAll(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        response.setStatus(200);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Product List</h1>");
        out.println("<ul>");
        for (Product product : productService.getAll()) {
            out.println(String.format("<li><div><p><span>id:</span> %s</p><p><span>name:</span> %s</p><p><span>brand:</span> %s</p><p><span>category:</span> %s</p><p><span>price:</span> $%s</p></div></li>", product.getId(), product.getName(), product.getBrand(), product.getCategory(), product.getPrice()));
        }
        out.println("</ul></body></html>");
    }

    private void getOne(HttpServletResponse response, int id) throws IOException {
        Product product = productService.getAll().stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElse(null);
        if(product == null) {
            response.setStatus(404);
            return;
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Product Details</h1>");
        out.println(String.format("<div><p><span>id:</span> %s</p><p><span>name:</span> %s</p><p><span>brand:</span> %s</p><p><span>category:</span> %s</p><p><span>price:</span> $%s</p></div>", product.getId(), product.getName(), product.getBrand(), product.getCategory(), product.getPrice()));
        out.println("</body></html>");
    }
}
