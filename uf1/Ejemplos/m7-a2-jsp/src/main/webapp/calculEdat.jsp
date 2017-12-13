<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
public long calculaEdat(){
    LocalDate now = LocalDate.now();
    return ChronoUnit.YEARS.between(dataNaixement, now);
}
LocalDate dataNaixement = LocalDate.of(1986, 3, 11);
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
                String nomPersona = "Clara";
                String cognoms = "Oswin";
                

            %>
            <li>Es diu: <%=nomPersona + " " + cognoms%> </li>
            <li>Té <%=calculaEdat()%>   anys</li>
            <li>Va néixer l'any: <%=dataNaixement.toString()%> </li>

        </ul>
    </body>
</html>
