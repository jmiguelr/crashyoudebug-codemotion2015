package eu.jmiguel.cm2015;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Handcrafted by jmiguel on Halloween!
 */


public class cmcrash extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        procesaPeticion(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }


    private void procesaPeticion(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String campo1 = request.getParameter("campo1");
        String campo2 = request.getParameter("campo2");

        String pierdetiempo = pierdeTiempo();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.write("<html><head></head><body bgcolor='#EEEEEE' text='#000000'>");
        out.write("<center><h1>");

        out.write("<p>Tenemos [" + campo1 + "] y [" + campo2 + "]<p>");
        out.write("<p>Pierde tiempo es  [" + pierdetiempo + "]</p>");


        out.write("</h1></center>");

        out.write("</body></html>");
        out.flush();

    }


    private String pierdeTiempo() {
        String vuelta ;
        Long startTime = System.currentTimeMillis();

        try {
            Thread.currentThread().setName("CODEMOTION - " + Thread.currentThread().getName());
            Thread.sleep(15 * 1000);
            vuelta = "No nos interrumpen";
        } catch (InterruptedException e) {
            vuelta = "Quien osa interrumpir!! (" + (System.currentTimeMillis() - startTime) + "ms)";
        }


        return vuelta;
    }

}
