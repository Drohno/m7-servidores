<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private int rand(int min, int max) {
        return (int) (Math.random() * (max + 1 - min) + min);
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestió de taules d'un restaurant</title>
    </head>
    <body>
        <%
            //inicialització de les taules amb els comensals
            int[] taules = new int[10];
            for (int i = 0; i < 10; i++) {
                taules[i] = rand(0, 5);
            }
            request.setAttribute("taules", taules);
        %>
        <h1>Gestió de taules d'un restaurant</h1>
        <ul>
            <c:forEach var="num" varStatus="loop"  items="${taules}">
                <c:choose>
                    <c:when test="${num eq 0}">
                        <c:out value="${'<li>La taula'} ${loop.index} ${'està buida</li>'}" escapeXml="false"></c:out>
                    </c:when>
                    <c:when test="${num eq 5}">
                        <c:out value="${'<li>La taula'} ${loop.index} ${' està plena</li>'}" escapeXml="false"></c:out>
                    </c:when>
                    <c:otherwise>
                        <c:out value="${'<li>La taula'} ${loop.index} ${' té '} ${num} ${'comensals</li>'}" escapeXml="false"></c:out>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </body>
</html>

