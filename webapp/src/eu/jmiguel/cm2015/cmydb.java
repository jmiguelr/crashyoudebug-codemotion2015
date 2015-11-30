package eu.jmiguel.cm2015;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Handcrafted by jmiguel
 */


public class cmydb extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        procesaPeticion(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }


    private void procesaPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nacimiento = request.getParameter("nacimiento");

        calculaDecada(nacimiento) ;

        Integer nacimientoNumerico = new Integer(nacimiento);       // Linea 28
        Integer edad = 2015 - nacimientoNumerico;

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.write("<html><head></head><body bgcolor='#EEEEEE' text='#000000'>");
        out.write("<center><h1>");

        out.write("<p>Si naciste en " + nacimiento + " tienes " + edad + " años <p>");

        out.write("</h1></center>");
        out.write("</body></html>");
        out.flush();

    }
    private String calculaDecada( String anyoNacimiento) {
        String decada = anyoNacimiento.substring(2,3) + "0" ;   // Linea 44
        return decada;
    }

}
