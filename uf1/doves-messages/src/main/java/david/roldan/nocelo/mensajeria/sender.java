/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.roldan.nocelo.mensajeria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

         /******************************************************************\
         *                                                                  *
         *              Proudly coded by David Roldan Nocelo                *
         *                                                                  *
         \******************************************************************/

public class sender extends HttpServlet {

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
        //Comprobamos que no se haya entrado accediendo a la URL directamente   
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            String usuario = req.getUserPrincipal().getName();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>Write New</title>");
            out.println("<style>\n"
                    + "body{\n"
                    + "    background-color: #000;\n"
                    + "    color: #fff;\n"
                    + "}\n"
                    + "\n"
                    + "div{\n"
                    + "    text-align: center;\n"
                    + "    margin-top: 100px;\n"
                    + "    width: 400px;\n"
                    + "    margin: 0 auto;\n"
                    + "}\n"
                    + "\n"
                    + "button, .boton{\n"
                    + "    background-color: #6666ff;\n"
                    + "    color: #fff;\n"
                    + "    font-weight: bolder;\n"
                    + "}"
                    + "</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Writting New Message</h1>");
            out.println("<hr>");
            out.println("<form method='POST' action='sender'>");
            out.println("<p>To:</p>");
            listarUsuarios(usuario, out);
            out.println("<p>Message body:</p>");
            out.println("<textarea id='mensaje' name='mensaje' style='height: 200px; width: 400px;' maxlength='250' required></textarea>");
            out.println("<p><span id='escritos'>0</span>/250</p>");
            out.println("<br>");
            out.println("<input class='boton' type='submit' value='Send'>");
            out.println("</form>");
            out.println("<hr>");
            out.println("<button onclick='window.location.href=\"core\"'>Go back</button>");
            out.println("</div>");
            out.println("<script>"
                    + "document.getElementById('mensaje').addEventListener('input', function(){"
                    + "var textarea = document.getElementById('mensaje');"
                    + "document.getElementById('escritos').innerHTML = textarea.value.length;"
                    + "});"
                    + "</script>"
            );
            out.println("</body>");
            out.println("</html>");
        }

    }

    private void listarUsuarios(String usuario, PrintWriter out) {
        System.err.println(timestamp() + "Iniciando Listado de usuarios en messages/");

        File folder = new File("messages/");
        File[] listOfFiles = folder.listFiles();

        out.println("<select class='boton' name='destino'>");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //System.out.println("File " + listOfFiles[i].getName());
                //out.print("<a>" + listOfFiles[i].getName() + "</a>");

            } else if (listOfFiles[i].isDirectory()) {
                System.err.println("Directory " + listOfFiles[i].getName());
                //Descomentar para que no aparezca nuestro usuario dentro del selector
                if (!listOfFiles[i].getName().equals(usuario)) {
                    out.println("<option value='" + listOfFiles[i].getName() + "'>" + listOfFiles[i].getName() + "</option>");
                }
            }
        }
        out.println("</select>");
    }

    private String timestamp() {
        Date ahora = new Date();
        String fecha = ahora.getHours() + ":" + ahora.getMinutes() + ":" + ahora.getSeconds();
        return fecha;
    }

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

    private String timestampMSG() {
        Date ahora = new Date();
        String fecha = (ahora.getYear() + 1900) + "-" + ahora.getMonth() + "-" + ahora.getDay() + "-" + ahora.getHours() + ":" + ahora.getMinutes();
        return fecha;
    }

    private boolean escribirMensaje(String origen, String destino, String mensaje) {

        System.err.println(timestamp() + "Iniciando escritura de mensaje de " + origen + " a " + destino);

        try {
            FileWriter outbox = new FileWriter("./messages/" + destino + "/recibidos/" + timestampMSG() + "-" + origen + ".msg", true);
            outbox.write(mensaje);
            outbox.close();

            FileWriter inbox = new FileWriter("./messages/" + origen + "/enviados/" + timestampMSG() + "-" + destino + ".msg", true);
            inbox.write(mensaje);
            inbox.close();
            return true;

        } catch (Exception err) {
            System.err.println(timestamp());
            System.err.println(err);
            return false;
        }

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
        String usuario = req.getUserPrincipal().getName();
        String destino = req.getParameter("destino");
        String mensaje = req.getParameter("mensaje");
        try (PrintWriter out = res.getWriter()) {
            escribirMensaje(usuario, destino, mensaje);
            res.sendRedirect("core");
            /*
            if(escribirMensaje(origen, destino, mensaje)){
                out.print("<a href='core'>Mensaje enviado correctamente</a>");
            } else {
                out.print("<a href='core'>Hubo un error al enviar mensaje. Lo sentimos T_T</a>");
            }
             */
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

         /******************************************************************\
         *                                                                  *
         *              Proudly coded by David Roldan Nocelo                *
         *                                                                  *
         \******************************************************************/