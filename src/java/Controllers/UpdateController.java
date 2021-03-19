/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Products.ProductDAO;
import Products.ProductDTO;
import Products.ProductErrorDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quoc Huy
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "SearchController";
    private static final String INVALID = "update.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductErrorDTO error = new ProductErrorDTO();
        try {
            boolean valid = true;
            String productID = request.getParameter("txtProductID");
            String name = request.getParameter("txtName");
            int price = 0;
            try {
                price = Integer.parseInt(request.getParameter("txtPrice"));
            } catch (Exception e) {
                valid = false;
                error.setPriceError("Price must be a number");
            }
            int quantity = 0;
            try {
                quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            } catch (Exception e) {
                valid = false;
                error.setQuantityError("Quantity must be a number");
            }
            if (name != null && (name.length() < 5 || name.length() > 100)) {
                error.setNameError("Name product must be [5-100]");
                valid = (false);
            }
            if (price < 0) {
                error.setPriceError("Price must be > 0");
                valid = (false);
            }
            if (quantity < 0) {
                error.setQuantityError("Quantity must be > 0");
                valid = false;
            }

            String categoryID = request.getParameter("txtCategoryID");
            if (categoryID != null && !(categoryID.matches("^\\w{1}[CA]\\d{1}[0-9]$"))) {
                error.setCategoryIDError("CategoryID must be same format CAXX");
                valid = (false);
            }

            ProductDTO dto = new ProductDTO(productID, name, price, quantity, categoryID);
            System.out.println("productID" + productID);
            log("valid: " + valid);
            if (valid) {
                ProductDAO dao = new ProductDAO();
                if (dao.updateProduct(dto)) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("INVALID", error);
                url = INVALID;
                request.setAttribute("DTO", dto);
            }

        } catch (Exception e) {
            log("Error at Update Controller" + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
