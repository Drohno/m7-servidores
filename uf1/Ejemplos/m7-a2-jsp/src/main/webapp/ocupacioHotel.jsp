
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private static final int NUM_PLANTES = 5;
    private static final int NUM_HAB = 10;
    private static final int MAX_CLIENTS = 5;

    private int rand(int min, int max) {
        return (int) (Math.random() * (max + 1 - min) + min);
    }

    private int[] ocupacio(int[][] hotel) {
        int[] ocupades = new int[NUM_PLANTES];
        int num = 0;
        for (int pis = 0; pis < NUM_PLANTES; pis++) {
            for (int hab = 0; hab < NUM_HAB; hab++) {
                if (hotel[pis][hab] != 0) {
                    num++;
                }
            }
            ocupades[pis] = num;
            num = 0;
        }
        return ocupades;
    }

    private boolean habBuides(int[][] hotel) {
        boolean trobat = false;
        int pis = 0, porta = 0;
        while (!trobat && pis < NUM_PLANTES) {
            if (hotel[pis][porta] == 0) {
                trobat = true;
            }
            if (porta == NUM_HAB - 1) {
                porta = 0;
                pis++;
            } else {
                porta++;
            }

        }
        return trobat;
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

            %>
        <ul>
            <%            //Llistat amb l'ocupació del hotel
                int planta = 0;
                for (int num : ocupacio(hotel)) {
                    switch (num) {
                        case 0:
                            out.println("<li>A la planta " + planta + " estan totes les habitacions buides</li>");
                            break;
                        case NUM_HAB:
                            out.println("<li>A la planta " + planta + " estan totes les habitacions plenes.</li>");
                            break;
                        default:
                            out.println("<li>A la planta " + planta + " hi han " + num + " habitacions ocupades.</li>");
                    }
                    planta++;
                }
            %>
        </ul>
        <h2><%= habBuides(hotel)? "Al menys hi ha una habitació lliure." : "No existeixen habitacions lliures." %></h2>
    </body>
</html>
