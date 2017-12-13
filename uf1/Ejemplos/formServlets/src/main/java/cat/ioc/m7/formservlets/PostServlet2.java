package cat.ioc.m7.formservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


@WebServlet(name = "PostServlet2", urlPatterns = {"/PostServlet2"})
public class PostServlet2 extends HttpServlet {
    
    @Resource Validator validator;
    
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
            out.println("<title>Servlet ServletValidation2</title>");            
            out.println("</head>");
            out.println("<body>");

            String missatge = request.getParameter("missatgePost");
            String mail = request.getParameter("mail");
            String edat = request.getParameter("edat");
            
            PostBean2Local bean = (PostBean2Local) new InitialContext().lookup(
                    "java:global/formServlets/PostBean2");
                    
            
            bean.setMessage(missatge);
            bean.setEmail(mail);
            bean.setEdat(edat);
            
            out.println("<h1>Dades rebudes del Formulari</h1>");
            out.println("<p>Missatge: " + bean.getMessage() + "</p>");
            out.println("<p>Edat: " + bean.getEdat() + "</p>");
            out.println("<p>Email: " + bean.getEmail() + "</p>");
            
            out.println("<h1>Llistat de validacions:</h1>");
            for (ConstraintViolation c : validator.validate(bean)) {
                out.println("<p>" + c.getMessage() + "</p>");
            }
            
            out.println("</body>");
            out.println("</html>");
        } catch (NamingException ex) {
            Logger.getLogger(PostServlet2.class.getName()).log(Level.SEVERE, null, ex);
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