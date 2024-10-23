package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;

/**
 * Servlet implementation class servletUsuario
 */
@WebServlet("/servletUsuario")
public class servletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		SeguroDao seguroDao = new SeguroDao();
        ArrayList<Seguro> listaSeguros = seguroDao.obtenerSeguros(); // Obtenemoslista de seguros
        System.out.println("Lista de seguros: " + listaSeguros);

        request.setAttribute("listaS", listaSeguros); // Pasamos la lista a la JSP

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarSeguros.jsp");
        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SeguroDao seguroDao = new SeguroDao();
		String idTipoS = request.getParameter("idTipo");
		int idTipo = Integer.parseInt(idTipoS);
        ArrayList<Seguro> listaSeguros = seguroDao.obtenerSegurosSegunTipo(idTipo); 

        request.setAttribute("listaS", listaSeguros); 

        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarSeguros.jsp");
        dispatcher.forward(request, response);
	}

}
