/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartProducts;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quoc Huy
 */
@WebServlet(name = "MainControllerCart", urlPatterns = {"/MainControllerCart"})
public class MainControllerCart extends HttpServlet {
    private final static String ERROR = "error.jsp";
    private final static String ADD_CONTROLLER = "AddCartController";
    private final static String VIEW_CART = "cart1.jsp";
    private final static String DELETE_CONTROLLER = "DeleteCartController";
    private final static String UPDATE_CONTROLLER = "UpdateCartController";
    private final static String SEARCH_CONTROLLER = "SearchUSCartController";
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
            /* TODO output your page here. You may use following sample code. */
            String url = ERROR;
            try {
                String action = request.getParameter("action");
                log(action);
                if ("Add to cart".equals(action)){
                    url = ADD_CONTROLLER;
                }else if("View cart".equals(action)){
                    url = VIEW_CART;
                }else if("Delete".equals(action)){
                    url = DELETE_CONTROLLER;
                }else if("Update".equals(action)){
                    url = UPDATE_CONTROLLER;
                    
                }else if("Find".equals(action)){
                    url = SEARCH_CONTROLLER;
                }
            
            } catch (Exception e) {
                log("Error at Maincartcontroller:" + e.getMessage());
            }finally{
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
