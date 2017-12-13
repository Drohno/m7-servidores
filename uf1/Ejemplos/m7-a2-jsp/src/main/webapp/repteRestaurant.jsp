<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private int rand(int min, int max) {
        return (int) (Math.random() * (max + 1 - min) + min);
    }
    
    private ArrayList cercarBuides(int[] taules){
        ArrayList buides = new ArrayList();
        for (int i = 0; i < taules.length; i++) {
            if(taules[i] == 0){
                buides.add(i);
            }
        }
        return buides;
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
            //cerquem les taules buides
            ArrayList taulesBuides = cercarBuides(taules);
            
        %>
        <h1>Les següents taules estan buides:</h1>
        <ul>
            <%
                //listat de les taules buides
                if(taulesBuides.isEmpty()){
                    out.println("No hi han taules buides.");
                }
              
                for (Object taula: taulesBuides){
                    out.println("<li>La taula " + taula + " està buida.</li>");
                }
            %>
        </ul>
    </body>
</html>

