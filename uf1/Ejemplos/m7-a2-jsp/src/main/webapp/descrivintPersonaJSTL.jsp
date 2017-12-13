
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <c:set var="edat" value="30" scope="page" />
        <fmt:parseDate   var="datanaixement" pattern="dd-MM-yyyy" value="11-03-1986"/>
        <c:set var="telef" value="935555555" scope="page" />
        <c:set var="adreca" value="Blackpool, England" scope="page" />
        <c:set var="email" value="oswin@dr.who" scope="page" />
        <c:set var="treballa" value="false" scope="page" />
        <c:set var="estudia" value="true" scope="page" />
        <c:set var="alcada" value="167.23f" scope="page" />


        <ul>
            <li>Es diu: <c:out value="${nom} ${cognoms}" /></li>
            <li>Té <c:out value="${edat}" />   anys</li>
            <li>Va néixer el  <fmt:formatDate value="${datanaixement}" dateStyle="full"/>.</li>
            <li>El seu telèfon és el: <c:out value="${telef}" /> </li>
            <li>Viu a <c:out value="${adreca}" /> </li>            
            <li>El seu e-mail és el <c:out value="${email}" /> </li>            
            <li> actualment <c:out value="${treballa? '' : 'no'}" /> treballa i <c:out value="${estudia? '' : 'no'}" /> estudia.</li>
            <li>i té una alçada de <c:out value="${alcada + 1}" /> cm.</li>                        

        </ul>

    </body>
</html>
