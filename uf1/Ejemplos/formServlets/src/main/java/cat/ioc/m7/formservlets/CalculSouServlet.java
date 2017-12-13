
package cat.ioc.m7.formservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculSouServlet", urlPatterns = {"/CalculSouServlet"})
public class CalculSouServlet extends HttpServlet {

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
            out.println("<title>Servlet formServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Dades rebudes del Formulari</h1>");
            
            int brut = Integer.parseInt(request.getParameter("salariBrut"));
            out.println("<p>Salari Brut: " + brut + "</p>");
            
            int fills = Integer.parseInt(request.getParameter("fills"));
            out.println("<p>Nombre de fills: " + fills + "</p>");
            
            out.println("<h1>Càlcul del salari net:</h1>");
            int retencio = 21 - (5*fills);
            
            // Formula per calcular la retenció: k = (int)(value*(percentage/100.0f));            
            int net = brut -((int)(brut * (retencio/100.0f)));
            
            out.println("<p>Tens una retenció del " + retencio + " per cent</p>");
            out.println("<p>El teu salari net és de " + net + " euros</p>");
            out.println("<a href='calcularSou.html'> Tornar </a>");
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
