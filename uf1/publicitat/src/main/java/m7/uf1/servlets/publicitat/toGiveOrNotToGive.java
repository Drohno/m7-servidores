/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m7.uf1.servlets.publicitat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David
 */
public class toGiveOrNotToGive extends HttpServlet {

    private int num, visitesGlobals;
    private String videoPubliYT;
    private Map <String, Integer> ip = new HashMap <String, Integer>();       

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        this.ip = new HashMap();
        this.num++;
        this.visitesGlobals = 0;
        this.videoPubliYT = getServletConfig().getInitParameter("videoPubliYT");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //try (PrintWriter out = response.getWriter()) {
        this.visitesGlobals++;
        /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet toGiveOrNotToGive</title>");
            out.println("</head>");
            out.println("<body><center>");
         */
        String requestIp = request.getRemoteAddr(); 
        if (this.ip.containsKey(requestIp)) {
            this.ip.put(requestIp, (this.ip.get(requestIp)+1));
            //Método en que redirigimos a otra página y cambia la URL por lo que al hacer F5, no recarga el servlet sino la propia página
            //response.sendRedirect("menu.html");
            //Método de redirección usando dispatcher. Pasamos tanto la request como la response y la url del cliente no cambia
            RequestDispatcher rs = request.getRequestDispatcher("servMenu");
            //Añadimos en el request el número de visitas que nos ha hecho
            request.setAttribute("visita", this.ip.get(requestIp));
            request.setAttribute("visitesGlobals", visitesGlobals);
            rs.forward(request, response);

            //notToGive(requestIp, out);
        } else {
            //toGive(requestIp, out);

            this.ip.put(requestIp, 1);
            //Método en que redirigimos a otra página y cambia la URL por lo que al hacer F5, no recarga el servlet sino la propia página
            //response.sendRedirect("publicitat.html");
            //Método de redirección usando dispatcher. Pasamos tanto la request como la response y la url del cliente no cambia
            RequestDispatcher rs = request.getRequestDispatcher("servPubli");
            request.setAttribute("visita", this.ip.get(requestIp));
            request.setAttribute("visitesGlobals", visitesGlobals);
            rs.forward(request, response);

        }
        /*
            if(this.visitesGlobals == 1){
                out.println("<h5>Benvingut! És la primera visita que ens fas! Esperem que no sigui l'última :3</h5>");
            }else{
                out.println("<h5>S'han fet " + this.visitesGlobals + " visites globals</h5>");
            }
            if(this.num == 1){
                out.println("<h5>S'ha cridat el mètode init " + this.num + " vegada</h5>");
            }else{
                out.println("<h5>S'ha cridat el mètode init " + this.num + " vegades</h5>");
            }
            
            out.println("</center></body>");
            out.println("</html>");
         */
        //}
    }
    /*
    private void notToGive(String IP, PrintWriter out) {
        this.ip.replace(IP,this.ip.get(IP)+1);
        out.println("<img alt=\"David Bowie Pop Art\" src=\"images/pop-art.jpg\" style=\"width: 50%;\">");
    }

    private void toGive(String IP, PrintWriter out) {
        this.ip.put(IP, 1);
        out.println("<iframe width=\"854\" height=\"480\" src=\"https://www.youtube.com/embed/" + this.videoPubliYT + "\" frameborder=\"0\" allowfullscreen></iframe>");
    }
     */
}
