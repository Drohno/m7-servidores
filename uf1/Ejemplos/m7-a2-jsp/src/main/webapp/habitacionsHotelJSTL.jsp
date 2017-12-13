<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static final int NUM_PLANTES = 5;
    private static final int NUM_HAB = 10;
    private static final int MAX_CLIENTS = 5;
    private int rand(int min, int max) {
        return (int) (Math.random() * (max + 1 - min) + min);
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestió de les habitacions d'un hotel</title>
    </head>
    <body>
        <H1>Gestió de les habitacions d'un hotel</H1>
        <%           
            //inicialització de les taules amb els comensals
            int[][] hotel = new int[NUM_PLANTES][NUM_HAB];
            for (int pis = 0; pis < NUM_PLANTES; pis++) {
                for (int hab = 0; hab < NUM_HAB; hab++) {
                    hotel[pis][hab] = rand(0, MAX_CLIENTS);
                }
            }
            request.setAttribute("hotel", hotel);
            //Llistat amb el numero de clients per habitacions
        %>
        <ul>
            <c:forEach var="planta" varStatus="numplanta" items="${hotel}">  
                <c:forEach var="clients" varStatus="numporta"  items="${planta}">
                        <c:out value="${'<li>La habitació'} ${numporta.index} ${'de la planta'} ${numplanta.index} ${'té'} ${clients} ${'clients</li>'}" escapeXml="false"></c:out>
                </c:forEach>
            </c:forEach>
        </ul>
    </body>
</html>