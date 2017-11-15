/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.roldan.nocelo.mensajeria;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author david
 */
public class core extends HttpServlet {

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
        //Comprobamos que no se haya entrado accediendo a la URL directamente   
        if (session.getAttribute("usuario") == null || session.getAttribute("usuario") == "") {
            res.sendRedirect("login.html");
        } else {
            res.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = res.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Inbox</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Welcome: " + session.getAttribute("usuario") + "</h1>");
                out.println("<hr>");
                out.println("<button onclick=window.location.href='sender'>Write New</button>");
                //TODO Funcion que liste el contenido de mensajes recibidos
                out.println("<h3>Messages received</h3>");
                listarDirectorio(session.getAttribute("usuario").toString(), "recibidos", out);
                //TODO Funcion que liste el contenido de mensajes enviados
                out.println("<h3>Messages sent</h3>");
                listarDirectorio(session.getAttribute("usuario").toString(), "enviados", out);
                out.println("<br>");
                out.println("<button onclick='window.location.href=\"login\"'>Close session</button>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
    
    private void listarDirectorio(String usuario, String directorio, PrintWriter out){
        
        System.err.println(timestamp() + "Iniciando Listado del directorio messages/" + usuario+ "/" + directorio);
        
        File folder = new File("messages/"+ usuario+ "/" + directorio);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //System.out.println("File " + listOfFiles[i].getName());
                out.print("<a href='shower?folder="+directorio+"&mensaje="+listOfFiles[i].getName()+"'>" + listOfFiles[i].getName() + "</a>");
                out.print("<br>");
                
            } else if (listOfFiles[i].isDirectory()) {
                //System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
    
    private String timestamp() {
        Date ahora = new Date();
        String fecha = ahora.getHours() + ":" + ahora.getMinutes() + ":" + ahora.getSeconds();
        return fecha;
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
