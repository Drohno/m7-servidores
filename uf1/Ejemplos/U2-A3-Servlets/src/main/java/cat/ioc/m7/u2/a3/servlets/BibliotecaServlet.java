
package cat.ioc.m7.u2.a3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "bibliotecaServlet", urlPatterns = {"/bibliotecaServlet"})
public class BibliotecaServlet extends HttpServlet {

    @EJB
    private BibliotecaLocal b;

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet provaServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet provaServlet at " + request.getContextPath() + "</h1>");

            try {
                 out.println("<p>Usuari: " + request.getUserPrincipal() + "</p>");
                if(request.isUserInRole("bibliotecari")){
                    out.println("<p>" + b.catalogar("java") + "</p>");
                    out.println("<p>" +  b.veureDisponibilitat("php") + "</p>");
                }
                if(request.isUserInRole("user")){
                    out.println("<p>" + b.veureDisponibilitat("java") + "</p>");
                }
               
                if(b.demanarPrestec("java")){
                    out.println("<p> Mai es veurà aquest text.</p>");
                }
            } catch (EJBAccessException e) {
                out.println("<p>No tens els privilegis suficients per realitzar aquesta acció.</p>");
            }

            out.println("</body>");
            out.println("</html>");
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
