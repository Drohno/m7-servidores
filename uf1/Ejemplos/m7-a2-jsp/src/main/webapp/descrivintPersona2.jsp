<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    String nomPersona = "Clara";
    String cognoms = "Oswin";
    int edat = 30;
    LocalDate dataNaixement = LocalDate.of(1986, 3, 11);
    String telf = "935555555";
    String adrecaPostal = "Blackpool, England";
    String email = "oswin@dr.who";
    boolean treballa = false;
    float alcada = 167.23f;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Descrivint a una Persona</title>
    </head>
    <body>
        <h1>Descrivint a una persona</h1>
        <h2> Les dades de la persona son:</h2>
        <ul>
            <%
            String html = "<li>Es diu: " + nomPersona + " " + cognoms + " </li>";
            html += "<li>Té" + edat + " anys</li>";
            html += "<li>Va néixer l'any:"+ dataNaixement.toString() + "</li>";
            html += "<li>El seu telèfon és el: " + telf + "</li>";
            html += "<li>Viu a " + adrecaPostal + " </li>";            
            html += "<li>El seu e-mail és el " + email + " </li>";            
            html += "<li> actualment " + ((treballa) ? "si" : "no") + " treballa.</li>";
            html += "<li>i té una alçade de " +  alcada + " cm.</li>";
            out.println(html);
            
         %>
        </ul>
    </body>
</html>
