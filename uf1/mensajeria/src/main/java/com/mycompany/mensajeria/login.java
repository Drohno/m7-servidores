/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajeria;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
public class login extends HttpServlet {

    void newUser(String usuario) {
        File f = null;
        boolean bool = false;

        try {

            // returns pathnames for files and directory
            f = new File("./messages/" + usuario);

            // create
            bool = f.mkdirs();

            // print
            System.out.println("Directory created? " + bool);

        } catch (Exception e) {

            // if any error occurs
            e.printStackTrace();
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        /*
        newUser("david");
        newUser("roger");
        newUser("roger");
        */
    }
    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Poner algo interesante aqui
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("usuario");
		String pass = req.getParameter("password");
		if (
                        ("david".equals(user) && "admin".equals(pass))
                        ||
                        ("roger".equals(user) && "admin".equals(pass))
                        ||
                        ("carlos".equals(user) && "admin".equals(pass))
                        ) {
			response(resp, "login ok");
		} else {
			response(resp, "invalid login");
		}
	}

	private void response(HttpServletResponse resp, String msg)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + msg + "</t1>");
		out.println("</body>");
		out.println("</html>");
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
