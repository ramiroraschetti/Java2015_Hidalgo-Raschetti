package Controlador;


import java.util.ArrayList;

import Datos.DbPartidas;
import Datos.DbPiezas;
import Entidades.Partida;
import Entidades.Pieza;

public class CtrlJugar {

	private DbPartidas catalogoPartida;
	private DbPiezas catalogoPiezas;
	
	
	public CtrlJugar(){
		catalogoPartida = new DbPartidas();
		catalogoPiezas = new DbPiezas();

	}
	
	public Partida iniciarPartida(int dni1, int dni2) { 				//Iniciar partida nueva si no hay partida abierta, si no retomar partida abierta
		Partida p = new Partida();
		if(catalogoPartida.estadoPartida( dni1,  dni2) == true) //estadoPartdia devuelve true retoma partida iniciada
				
					p = catalogoPartida.retomarPartida( dni1,  dni2);
			else																	
					p = catalogoPartida.partidaNueva( dni1,  dni2);	
		return p;
	}

	public  void buscarOponente(int dni) {  														 //busca partidas abiertas con otros oponentes
		
		catalogoPartida.busqueda(dni);
	}
	
	public void guardarPiezas(Partida partida, Pieza pieza){										//Guarda todas las piezas
		catalogoPiezas.guardarPiezas(partida, pieza);
	}
		
	public ArrayList<Pieza> buscarPiezas(Partida partida, Pieza pieza){								//Busca Todas las Piezas
		return catalogoPiezas.buscarPiezas(partida.getIdPartida(), pieza.getColor());
	}
	public void actualizarPieza(Pieza p, Partida part){												//Actualiza pos y estado de la pieza en la partida
		catalogoPiezas.updatePieza(p, part);
	}

}
