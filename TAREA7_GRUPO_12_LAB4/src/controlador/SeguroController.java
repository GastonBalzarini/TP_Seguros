package controlador;

import dominio.Seguro;
import dominio.SeguroDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SeguroController")
public class SeguroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SeguroDao seguroDao = new SeguroDao();
        int nuevoIdSeguro = seguroDao.obtenerIdSeguroMaximo() + 1;  // Obtener el nuevo idSeguro
        request.setAttribute("nuevoIdSeguro", nuevoIdSeguro);  // Configurar el atributo para la JSP

        // Redirigir a la JSP de agregar seguro
        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	SeguroDao seguroDao = new SeguroDao();
        try {
            Seguro nuevoSeguro = new Seguro();
            
            nuevoSeguro.setIdSeguro(Integer.parseInt(request.getParameter("IdSeguro")));
            nuevoSeguro.setDescripcion(request.getParameter("descripcion"));
            nuevoSeguro.setIdTipo(Integer.parseInt(request.getParameter("idTipo"))); // Asegúrate de que el nombre coincida
            nuevoSeguro.setCostoContratacion(Float.parseFloat(request.getParameter("costoContratacion")));
            nuevoSeguro.setCostoAsegurado(Float.parseFloat(request.getParameter("costoAsegurado")));

            
            int filasAfectadas = seguroDao.agregarSeguro(nuevoSeguro);

            if (filasAfectadas > 0) {
                request.setAttribute("mensaje", "Seguro agregado exitosamente.");
            } else {
                request.setAttribute("mensaje", "Error al agregar el seguro.");
            }

        } catch (Exception e) {
            request.setAttribute("mensaje", "Se produjo un error: " + e.getMessage());
        }

        int nuevoIdSeguro = seguroDao.obtenerIdSeguroMaximo() + 1; // obtener nuevamente el idSeguro
        request.setAttribute("nuevoIdSeguro", nuevoIdSeguro);
        
        request.getRequestDispatcher("AgregarSeguro.jsp").forward(request, response); 
    }}
