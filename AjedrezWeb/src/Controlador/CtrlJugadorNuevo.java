package Controlador;

import Datos.DbJugadores;


public class CtrlJugadorNuevo {
	
	private DbJugadores catalogoJugadores;
	
	public CtrlJugadorNuevo(){
		
		catalogoJugadores = new DbJugadores();

	}
	
	public void guardarJugador(int dni, String nombre, String apellido){
		catalogoJugadores.guardarJugador(dni, nombre, apellido);
		
	}

}
