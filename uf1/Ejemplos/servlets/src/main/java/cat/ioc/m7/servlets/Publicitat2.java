package cat.ioc.m7.servlets;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Publicitat2 extends HttpServlet {

    private HashMap ip;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.ip = new HashMap();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestIp = request.getRemoteAddr();

        if (this.ip.containsKey(requestIp)) {

            //redirect html − resta de vegades
            response.sendRedirect("resta_vegades.html");

        } else {
            //forward
            //RequestDispatcher rd = request.getRequestDispatcher("1a_vegada.html");
            //rd.forward(request,response);

            //redirectHTML − 1a vegada
            response.sendRedirect("1a_vegada.html");
            this.ip.put(requestIp, "");
        }

    }
}
