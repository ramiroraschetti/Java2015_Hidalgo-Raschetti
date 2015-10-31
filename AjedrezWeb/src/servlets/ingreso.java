package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.CtrlJugar;

/**
 * Servlet implementation class ingreso
 */
@WebServlet("/ingreso")
public class ingreso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ingreso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni1 = Integer.valueOf(request.getParameter("dniJugador1"));
		int dni2 = Integer.valueOf(request.getParameter("dniJugador2"));
		String error= " ";
		
		
		Controlador.CtrlJugar cj= new CtrlJugar();
		Entidades.Jugador jug1 =  cj.buscarJugador(dni1);
		Entidades.Jugador jug2 =  cj.buscarJugador(dni2);
		if(jug1 == null){
						
			request.setAttribute("dni", dni1);
			request.getRequestDispatcher("JugadorNuevo.jsp").forward(request, response);
							}else if(jug2 == null){
													
								request.setAttribute("dni", dni2);
								request.getRequestDispatcher("JugadorNuevo.jsp").forward(request, response);
							} else{
									Entidades.Partida partida = cj.iniciarPartida(jug1, jug2);
									if(partida != null){
										request.setAttribute("msgError", error);
										request.getSession().setAttribute("partidaSession", partida);
										request.getRequestDispatcher("redirected.jsp").forward(request, response);
									}
		}
	}

}
