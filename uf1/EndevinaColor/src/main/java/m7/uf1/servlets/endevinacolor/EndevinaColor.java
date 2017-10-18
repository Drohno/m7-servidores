/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m7.uf1.servlets.endevinacolor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David Roldán Nocelo
 */
public class EndevinaColor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userColour = request.getParameter("color");
        String[] defaultColour;
        defaultColour = getServletConfig().getInitParameter("color").split(";");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='utf-8'>");
            out.println("<title>Resultat</title>");
            out.println("</head>");
            out.println("<body>");
            int max = defaultColour.length;
            int min = 0;
            Random rand = new Random();
            int numberRandom = rand.nextInt((max - min) + 1) + min; 
            //out.println("<h2>" + numberRandom + "</h2>");    
            if (userColour.equals(defaultColour[numberRandom])) {
                out.println("<center><h2>You really did it!!</h2>");
            } else {
                out.println("<center><h2>Fail! The right colour was: " + defaultColour[numberRandom] + "</h2>");
            }
            out.println("<br>");
            out.println("<a href='./GenerarIndice'>Try again!</a></center>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
