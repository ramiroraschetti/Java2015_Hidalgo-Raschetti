package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.CtrlJugar;
import Entidades.Partida;

/**
 * Servlet implementation class movimiento
 */
@WebServlet("/movimiento")
public class movimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movimiento() {
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
		String desde = request.getParameter("Origen");
		String hasta = request.getParameter("Destino");
		String error=" ";
		Controlador.CtrlJugar cj= new CtrlJugar();
		Partida partidaSession = (Partida) request.getSession().getAttribute("partidaSession");
		
		try {
			
			partidaSession.moverPieza(hasta.charAt(0), Integer.parseInt(String.valueOf(hasta.charAt(1))), desde.charAt(0), Integer.parseInt(String.valueOf(desde.charAt(1))));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error=e.getMessage();
		}
		
		cj.actualizarPieza(partidaSession);
		cj.actualizarPartida(partidaSession);
		if(partidaSession.isEstadoPartida()==false){
			
			request.getSession().setAttribute("partidaSession", partidaSession);
			request.getRequestDispatcher("JuegoFinalizado.jsp").forward(request, response);
			}else{
		request.setAttribute("msgError", error);
		request.getSession().setAttribute("partidaSession", partidaSession);
		request.getRequestDispatcher("redirected.jsp").forward(request, response);}
	}

}
