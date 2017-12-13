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
        %>
        <h1>Gestió de taules d'un restaurant</h1>
        <ul>
            <%
                //listat de les taules
                for (int i = 0; i < 10; i++) {
                    switch (taules[i]) {
                        case 0:
            %>
            <li>La taula <%=i%> està buida</li>
                <%
                        break;
                    case 5:
                %>
            <li>La taula <%=i%> està plena.</li>
                <%
                        break;
                    default:
                %>
            <li>La taula <%=i%> té <%=taules[i]%> comensals</li>
                <%
                        }
                    }
                %>
        </ul>
    </body>
</html>

