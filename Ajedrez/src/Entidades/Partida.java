package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Partida {

	private int idPartida;
	private int jugador1, jugador2;
	private String turno = "blanca"; //kike: hay que definir BLANCA o BLANCO, fijate el metodo
	private boolean estadoPartida= true; //true partida aun en juego - false partida finalizada
	private ArrayList<Pieza> piezasPartida = new ArrayList<Pieza>();
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public int getJugador1() {
		return jugador1;
	}
	public void setJugador1(int jugador1) {
		this.jugador1 = jugador1;
	}
	public int getJugador2() {
		return jugador2;
	}
	public void setJugador2(int jugador2) {
		this.jugador2 = jugador2;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isEstadoPartida() {
		return estadoPartida;
	}
	public void setEstadoPartida(boolean estadoPartida) {
		this.estadoPartida = estadoPartida;
	}
	public ArrayList<Pieza> getPiezasPartida() {
		return piezasPartida;
	}
	public void setPiezasPartida(ArrayList<Pieza> piezasPartida) {
		this.piezasPartida = piezasPartida;
	}
	
	
	public Partida() {}
	
	public Partida(int jugador1, int jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
				
	}
	
	
	public void cambiarTurno(){
        if (Objects.equals(turno, "blanco")) 
        		turno="negro"; 
        	else turno="blanco";
    }
	
	
	public void moverPieza(char mueveX, int mueveY, char posX, int posY) throws Exception {
		Posicion posicion = new Posicion(posX, posY);
		Posicion posicionHacia = new Posicion(mueveX, mueveY);
		Pieza piezaElegida = null;
		Pieza piezaAComer;
		boolean movimientoCome = false;
		
		//Buscamos la pieza a mover, la pieza a comer, y validamos que no este ocupada por una del mismo color
		for(Pieza pieza : getPiezasPartida()){
			if(posicion.equals(pieza.getPosicion())){
				piezaElegida = pieza;
			} 
			if(posicionHacia.equals(pieza.getPosicion())){
				if(pieza.getColor().equals(getTurno())){
					throw new Exception("La posicion a mover se encuentra ocupada por una pieza del mismo color");
				} else {
					movimientoCome = true;
					piezaAComer = pieza;
				}
			}					
		}
		
		if(piezaElegida == null){
			throw new Exception("No hay pieza en la posicion Origen");
		}
		
		
		if(piezaElegida.movimientoValido(mueveX, mueveY, movimientoCome)){
			//TODO: validacion x pieza 
		};
		
		//TODO: cambiar el estado de la pieza comida, sacarla del juego, cambiar de turnoss
	}
	
	
}
