/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david.roldan.nocelo.mensajeria;

import java.io.*;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author david
 */
public class login extends HttpServlet {

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

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        newUser("david");
        newUser("roger");
        newUser("carlos");
        newUser("ruben");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //TODO Poner algo interesante aqui
        res.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String user = req.getParameter("usuario");
        String pass = req.getParameter("password");
        if (("david".equals(user) && "admin".equals(pass))
                || ("roger".equals(user) && "admin".equals(pass))
                || ("carlos".equals(user) && "admin".equals(pass))
                || ("ruben".equals(user) && "admin".equals(pass))) {

            //Grabamos el usuario con el que hemos hecho login en la sesion actual  (rollo Cookies pero sin Cookies)
            HttpSession session = req.getSession();
            session.setAttribute("usuario", req.getParameter("usuario"));

            res.sendRedirect("core");
        } else {
            res.sendRedirect("badLogin.html");
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
