/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SEARCHAD = "SearchController";
    private static final String SEARCHUS = "SearchUSController";
    private static final String INSERT = "InsertController";
    private static final String LOGIN = "LoginController";
    private static final String UPDATE = "UpdateController";
    private static final String DELETE = "DeleteController";
    private static final String EDIT = "EditController";
    private static final String LOGOUT = "LogoutController";
    
    
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
        try {
            String action = request.getParameter("action");
            log(action);
                if(action.equals("Find")){
                    url = SEARCHUS;
                }else if(action.equals("Search")){
                    url = SEARCHAD;
                }
                else if(action.equals("Insert")){
                    url = INSERT;
                }
                else if(action.equals("Login")){
                    url = LOGIN;
                }
                else if(action.equals("Update")){
                    url = UPDATE;
                }
                else if(action.equals("Delete")){
                    url = DELETE;
                }
                else if(action.equals("Edit")){
                    url = EDIT ;
                }
                else if(action.equals("Logout")){
                    url = LOGOUT ;
                }
                else{
                    request.setAttribute("ERROR", "Your action is invalid");
                }
        } catch (Exception e) {
            log("Error at Main Controller : " + e.getMessage());
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
