/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.ioc.m7.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cfgs
 */
public class Publicitat extends HttpServlet {

    private int visites;

    private int num;
    private String urlPublicitat;
    private HashMap ip;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.ip = new HashMap();
        this.num++;
        this.visites = 0;
        this.urlPublicitat = getServletConfig().getInitParameter("url");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Publicitat</title>");
            out.println("</head>");
            out.println("<body>");

            String requestIp = request.getRemoteAddr();

            if (this.ip.containsKey(requestIp)) {

                noEsLaPrimeraVegada(out);
            } else {

                esLaPrimeraVegada(requestIp, out);

            }

            out.println("<h5>S'han fet " + this.visites + " visites</h5>");
            out.println("<h5>S'ha cridat el mètode init " + this.num + " vegades </h5>");
            out.println("</body>");
            out.println("</html>");

            this.visites++;
        }
    }

    private void noEsLaPrimeraVegada(PrintWriter out) {
        out.println("<h1>Gràcies per tornar a la pàgina web. Ja no veuràs el patrocinador.</h1>");
    }

    private void esLaPrimeraVegada(String requestIp, PrintWriter out) {
        this.ip.put(requestIp, "");

        out.println("<h1>És la primera vegada que accedeixes a la pàgina. Benvingut.</h1>");
        out.println("<p style='color:red;'>Accedeix al nostre patrocinador clicant al següent enllaç:</p>");
        out.println("<a href='" + this.urlPublicitat + "'>Pàgina web del patrocinador</a>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Esto no deberia salir");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Esto no deberia salir");
    }
}
