<%-- 
    Document   : visor
    Created on : 12-Dec-2017, 20:03:11
    Author     : david
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="java.net.URL"%>
<%@page import="org.apache.commons.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>El Tiempo de hoy</title>
        <style>
            table, tr,th,td{
                border: 1px solid black;
                border-collapse: collapse;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <%-- Scope maximo de dias: 11 dias hacia atras y 2 hacia adelante --%>
        <%
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            Date fecha = new Date();
            String today = formatter.format(fecha);
            
            /*
             * String dt = "2008-01-01";  // Start date
             * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             * Calendar c = Calendar.getInstance();
             * c.setTime(sdf.parse(dt));
             * c.add(Calendar.DATE, 1);  // number of days to add
             * dt = sdf.format(c.getTime());  // dt is now the new date
             */
        %>
        
        <c:set var = "today" value="<%=today%>" />
        <c:import var = "weatherInfo" url = "http://www.aemet.es/xml/provincias/${today}_Provincias_6908.xml"/>
        <x:parse xml = "${weatherInfo}" var = "output"/>
        <h1><x:out select = "$output/root/elaborado" /></h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Minima</th>
                <th>Maxima</th>
            </tr>
        <x:forEach select = "$output/root/prediccion/ciudad" var = "item">
            <tr>
                <td><x:out select = "id" /></td>
                <td><x:out select = "nombre" /></td>
                <td><x:out select = "minima" /> ºC</td>
                <td><x:out select = "maxima" /> ºC</td>
            </tr>
        </x:forEach>
        </table>
    </body>
</html>
