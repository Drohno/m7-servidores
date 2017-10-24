/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m7.uf1.servlets.publicitat;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class servPubli extends HttpServlet {

    private String videoPubliYT;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        this.videoPubliYT = getServletConfig().getInitParameter("videoPubliYT");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>servPub</title>");
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h2>Nos has visitado desde la IP:" + request.getRemoteAddr() + " por primera vez! Bienvenido 8D</h2>");
            out.println("<h2>Nos habéis visitado en total " + request.getAttribute("visitesGlobals").toString() + " veces</h2>");
            out.println("<iframe width=\"854\" height=\"480\" src=\"https://www.youtube.com/embed/" + this.videoPubliYT + "\" frameborder=\"0\" allowfullscreen></iframe>");
            out.println("</center></body></html>");
            
            
        }
    }
}
