package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.CtrlJugadorNuevo;

/**
 * Servlet implementation class newJugador
 */
@WebServlet("/newJugador")
public class newJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newJugador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni = Integer.valueOf(request.getParameter("Dni"));
		String name = request.getParameter("Nombre");
		String surname = request.getParameter("Apellido");
		Controlador.CtrlJugadorNuevo cjn = new CtrlJugadorNuevo();
		
		cjn.guardarJugador(dni, name, surname);
		response.sendRedirect("InicioAjedrez.html");
		
	}

}
