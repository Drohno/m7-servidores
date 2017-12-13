<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>�mbits de les variables a JSTL</title>
    </head>

    <body>
        <c:set var="test" value="Valor d'una variable d'�mbit de p�gina" scope="page" />

        <c:set var="test" value="Valor d'una variable d'�mbit de Request"
               scope="request" />

        <c:set var="test" value="Valor d'una variable d'�mbit de sessi�"
               scope="session" />

        <c:set var="test" value="Valor d'una variable d'�mbit d'aplicaci�"
               scope="application" />
        <h1>�mbits de les variables a JSTL/JSP:</h1>
        <table border="1">
            <tr>
                <td>
                    <b>�mbit per defecte: </b>
                </td>
                <td>
                    <c:out value="${test}" />
                </td>
            </tr>
            <tr>
                <td>
                    <b>�mbit de p�gina</b>
                </td>

                <td>
                    <c:out value="${pageScope.test}" />
                </td>
            </tr>

            <tr>
                <td>
                    <b>�mbit de Request: </b>
                </td>

                <td>
                    <c:out value="${requestScope.test}" />
                </td>
            </tr>

            <tr>
                <td>
                    <b>�mbit de sessi�</b>
                </td>

                <td>
                    <c:out value="${sessionScope.test}" />
                </td>
            </tr>

            <tr>
                <td>
                    <b>�mbit d'aplicaci�</b>
                </td>

                <td>
                    <c:out value="${applicationScope.test}" />
                </td>
            </tr>
        </table>
    </body>
</html>
