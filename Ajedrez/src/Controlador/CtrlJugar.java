package Controlador;


import Datos.DbPartidas;
import Entidades.Partida;
import Entidades.Pieza;

public class CtrlJugar {

	private DbPartidas catalogoPartida;
	//private Pieza[] piezasJuego;
	
	public CtrlJugar(){
		catalogoPartida = new DbPartidas();
//		piezasJuego = new Pieza[32];
	}
	
	public Partida iniciarPartida(int dni1, int dni2) { //Iniciar partida nueva si no hay partida abierta, si no retomar partida abierta
		Partida p = new Partida();
		if(catalogoPartida.estadoPartida( dni1,  dni2) == true) //estadoPartdia devuelve false es que no hay partida iniciada
				
					p = catalogoPartida.retomarPartida( dni1,  dni2);
			else																	
					p = catalogoPartida.partidaNueva( dni1,  dni2);	
		return p;
	}

	public  void buscarOponente(int dni) {   //busca partidas abiertas con otros oponentes
		
		catalogoPartida.busqueda(dni);
	}
	
	public Pieza[] buscarPiezas(){				//busqueda de arreglo entero de piezas  ¿? nose para q todavia
		return catalogoPartida.getPiezas();
	}

}
