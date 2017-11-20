/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.roldan.nocelo.mensajeria;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author david
 */
public class shower extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null || session.getAttribute("usuario") == "") {
            res.sendRedirect("login.html");
        } else {
            res.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = res.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet shower</title>");
                out.println("</head>");
                out.println("<body>");
                String mensaje = req.getParameter("mensaje");
                String persona = mensaje.substring(mensaje.lastIndexOf("-") + 1, mensaje.lastIndexOf("."));
                if (req.getParameter("folder").toLowerCase().equals("enviados")) {
                    out.println("<h1>Sent</h1>");
                    out.println("<h3>To: " + persona + "</h3>");
                } else {
                    out.println("<h1>Received</h1>");
                    out.println("<h3>From: " + persona + "</h3>");
                }
                String fecha = mensaje.substring(0, mensaje.lastIndexOf("-"));
                out.println("<h3>At: " + fecha + "</h3>");
                out.println("<h3>Text:</h3>");                
                String usuario = session.getAttribute("usuario").toString();
                String cuerpo = bodyFichero(usuario, req.getParameter("folder").toLowerCase(), mensaje);
                out.println("<textarea readonly style='height: 200px; width: 400px;'>" + cuerpo + "</textarea>");
                out.println("<br><br>");
                out.println("<button onclick='window.location.href=\"core\"'>Go back</button>");
                out.println("</body>");
                out.println("</html>");

            }
        }
    }

    private String bodyFichero(String usuario, String fichero, String nombreFichero) {
        File file = new File("messages/" + usuario + "/" + fichero + "/" + nombreFichero);
        String text = "";
        if (file.isFile() && file.getName().endsWith(".msg")) {
            try {
                // FileReader reads text files in the default encoding.
                FileReader fileReader = new FileReader("messages/" + usuario + "/" + fichero + "/" + nombreFichero);

                // Always wrap FileReader in BufferedReader.
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    text = text + line;
                }

                // Always close files.
                bufferedReader.close();
            } catch (Exception err) {
                text = "There was a reading error. We're sorry";
            }
        }
        return text;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("usuario") == null || session.getAttribute("usuario") == "") {
            res.sendRedirect("login.html");
        } else {
            res.sendRedirect("core");
        }
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
