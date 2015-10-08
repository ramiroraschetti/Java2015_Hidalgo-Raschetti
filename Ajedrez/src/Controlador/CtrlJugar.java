package Controlador;


import java.sql.SQLException;
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
	
	public Partida iniciarPartida(int dni1, int dni2) { 		//Iniciar partida nueva si no hay partida abierta, si no retomar partida abierta
		Partida p = new Partida();
		if(catalogoPartida.estadoPartida( dni1,  dni2) == true) //estadoPartdia devuelve true retoma partida iniciada
				{
					p = catalogoPartida.retomarPartida( dni1,  dni2);

				}
			else	{																
					p = catalogoPartida.partidaNueva( dni1,  dni2);	
					catalogoPiezas.guardarPiezas(p);}
		return p;
	}

	public  void buscarOponente(int dni) {  							 			 //busca partidas abiertas con otros oponentes
		
		catalogoPartida.busqueda(dni);
	}
	
	public void guardarPiezas(Partida partida){										//Guarda todas las piezas
		catalogoPiezas.guardarPiezas(partida);
	}
		
	public ArrayList<Pieza> buscarPiezas(Partida partida) {								//Busca Todas las Piezas
		return catalogoPiezas.buscarPiezas(partida);
	}
	public void actualizarPieza(Partida par){			    //Actualiza pos,estado de las piezas en la partida 
		catalogoPiezas.updatePiezas(par);
	}
	public void actualizarPartida(Partida par){				//Actualiza turno, estadoPartida de la partida
		catalogoPartida.updatePartida(par);
	}

}
