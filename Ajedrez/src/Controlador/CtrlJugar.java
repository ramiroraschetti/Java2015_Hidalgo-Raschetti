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
	
	public Partida iniciarPartida(int dniJug1, int dniJug2) { //Iniciar partida nueva si no hay partida abierta, si no retomar partida abierta
		Partida p = new Partida();
		if(catalogoPartida.estadoPartida(dniJug1, dniJug2) == false) //estadoPartdia devuelve false es que no hay partida iniciada
			
				p = catalogoPartida.partidaNueva(dniJug1, dniJug2);	//deben devolver de partidaNueva y retomarPArtida las
			else																	// piezas de la partida  con su respectiva posicion
				p = catalogoPartida.retomarPartida(dniJug1, dniJug2);
		return p;
	}

	public  void buscarOponente(int dniB) {   //busca partidas abiertas con otros oponentes
		
		catalogoPartida.busqueda(dniB);
	}
	
	public Pieza[] buscarPiezas(){				//busqueda de arreglo entero de piezas  ¿? nose para q todavia
		return catalogoPartida.getPiezas();
	}

}
