
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Descrivint a una Persona</title>
    </head>
    <body>
        <h1>Descrivint a una persona</h1>
        <h2> Les dades de la persona son:</h2>
        <c:set var="nom" value="Clara" scope="page" />
        <c:set var="cognoms" value="Oswin" scope="page" />
        <fmt:parseDate   var="datanaixement" pattern="dd-MM-yyyy" value="11-03-1986"/>
        <c:set var="avui" value="<%=new java.util.Date()%>" /> 
        <ul>
            <li>Es diu: <c:out value="${nom} ${cognoms}" /></li>
            <li>Té <c:out value="${avui.year - datanaixement.year}" /> anys</li>
            
        </ul>

    </body>
</html>