<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comptador</title>
    </head>
    <body>
         <%
          int comptador = 0;
         %>
        <h1>Hola has executat aquesta pàgina <%= ++comptador %> vegades.</h1>
    </body>
</html>