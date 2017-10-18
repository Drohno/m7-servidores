/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.roldan.calculadora;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fathzer.soft.javaluator.DoubleEvaluator;

/**
 *
 * @author David
 */
public class Logic extends HttpServlet {

    private final DoubleEvaluator evaluator = new DoubleEvaluator();
    private double calculoAnterior = 0;
    private String inputAnterior = "";
    private boolean error = false;
    private boolean primeraEjecucion = true;
    
    private final String bodyCalculadora = ""
            + "<center><div id=\"calculadora\">"
            + "<form action=\"./Logic\" method=\"post\">"
            + "<input id=\"calculo\" type=\"text\" name=\"calculo\" readonly>"
            + "<br>"
            + "<br>"
            + "<input type=\"submit\" name=\"calcular\" value=\"Calcular\">"
            + "</form>"
            + "<br>"
            + "<button onclick=\"number('7');\">7</button>"
            + "<button onclick=\"number('8');\">8</button>"
            + "<button onclick=\"number('9');\">9</button>"
            + "<br>"
            + "<button onclick=\"number('4');\">4</button>"
            + "<button onclick=\"number('5');\">5</button>"
            + "<button onclick=\"number('6');\">6</button>"
            + "<br>"
            + "<button onclick=\"number('1');\">1</button>"
            + "<button onclick=\"number('2');\">2</button>"
            + "<button onclick=\"number('3');\">3</button>"
            + "<br>"
            + "<button onclick=\"number('0');\">0</button>"
            + "<br>"
            + "<button onclick=\"number('(');\">(</button>"
            + "<button onclick=\"number(')');\">)</button>"
            + "<button onclick=\"number('+');\">+</button>"
            + "<button onclick=\"number('-');\">-</button>"
            + "<button onclick=\"number('/');\">/</button>"
            + "<button onclick=\"number('*');\">*</button>"
            + "<button onclick=\"number('^');\">^</button>"
            + "<button onclick=\"number('.');\">.</button>"
            + "<br>"
            + "<br>"
            + "<button onclick=\"esborrar();\">CE</button>"
            + "</div></center>";

    private final String scriptJS = "<script>"
            + "function number(simbolo){"
            + "var item = document.getElementById(\"calculo\");"
            + "var calculo = item.value;"
            + "calculo = calculo + simbolo;"
            + "item.value = calculo;"
            + "}"
            + ""
            + "function esborrar(){"
            + "var item = document.getElementById('calculo');"
            + "item.value =\"\";"
            + "}"
            + "</script>";

    private void calculadora(String input) {
        if (!input.isEmpty()) {
            // Evaluate an expression
            calculoAnterior = evaluator.evaluate(input);
            error = false;
        } else {
            error = true;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            if (error) {
                out.println("<center><h3><a href=\"./Logic\">Error. Volver atrás.</a></h3></center>");
                error = false;
            } else {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Calculator</title>");

                out.println(scriptJS);
                out.println("</head>");
                out.println("<body>");

                out.println(bodyCalculadora);

                if (!primeraEjecucion) {
                    out.println("<center><p>" + inputAnterior + " = " + calculoAnterior + "</p></center>");
                } else {
                    primeraEjecucion = false;
                }

                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        inputAnterior = request.getParameter("calculo");
        calculadora(inputAnterior);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "This servlet is intended to be aprt as a training protocol for myself";
    }// </editor-fold>

}
