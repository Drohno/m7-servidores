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

         /******************************************************************\
         *                                                                  *
         *              Proudly coded by David Roldan Nocelo                *
         *                                                                  *
         \******************************************************************/

public class core extends HttpServlet {

    /**
     * 
     * OLD METHOD by David Roldan Nocelo
     * 
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        newUser("david");
        newUser("roger");
        newUser("carlos");
        newUser("ruben");
    }
    * 
    * */
      
    
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
            
            /**
             * New Method by David Roldan Nocelo
             */
            newUser(usuario);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
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
                    + "a{color:greenyellow}"
                    + "a:visited{color:green}"
                    + ".borrar{color:red}"
                    + "</style>");
            out.println("<title>Inbox</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Welcome: " + usuario + "</h1>");
            out.println("<hr>");
            out.println("<button onclick=window.location.href='sender'>Write New</button>");
            //TODO Funcion que liste el contenido de mensajes recibidos
            out.println("<h3>Messages received</h3>");
            listarDirectorio(usuario, "recibidos", out);
            //TODO Funcion que liste el contenido de mensajes enviados
            out.println("<h3>Messages sent</h3>");
            listarDirectorio(usuario, "enviados", out);
            out.println("<hr>");
            out.println("<button onclick=window.location.href='closeSession'>Close Session</button>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    private void listarDirectorio(String usuario, String directorio, PrintWriter out) {

        System.err.println(timestamp() + "Iniciando Listado del directorio messages/" + usuario + "/" + directorio);

        File folder = new File("messages/" + usuario + "/" + directorio);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                //System.out.println("File " + listOfFiles[i].getName());
                out.print("<a href='shower?folder=" + directorio + "&mensaje=" + listOfFiles[i].getName() + "'>" + listOfFiles[i].getName() + "</a><a class='borrar' href='dalek?folder=" + directorio + "&mensaje=" + listOfFiles[i].getName() + "' onclick='return confirm(\"Are you sure  to erase this message?\")'>\t[X]</a>");
                out.print("<br>");

            } else if (listOfFiles[i].isDirectory()) {
                //System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
    
    //Generamos los directorios de manera automatica con este proceso
    void newUser(String usuario) {
        System.err.println(timestamp() + " ---------Begin creation of directories---------");
        File f = null;
        boolean bool = false;

        try {

            // returns pathnames for files and directory
            f = new File("messages/" + usuario + "/enviados");
            // create
            bool = f.mkdirs();
            // print
            System.err.println(timestamp() + " ---------Directory created? " + bool + "---------");
            System.err.println(timestamp() + " --------- Where is created? " + f.getAbsolutePath() + "---------");

            // returns pathnames for files and directory
            f = new File("messages/" + usuario + "/recibidos");
            // create
            bool = f.mkdirs();
            // print
            System.err.println(timestamp() + " ---------Directory created? " + bool + "---------");
            System.err.println(timestamp() + " --------- Where is created? " + f.getAbsolutePath() + "---------");

        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
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

         /******************************************************************\
         *                                                                  *
         *              Proudly coded by David Roldan Nocelo                *
         *                                                                  *
         \******************************************************************/