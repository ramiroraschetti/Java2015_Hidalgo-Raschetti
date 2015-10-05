package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Partida {

	private int idPartida;
	private int jugador1, jugador2;
	private String turno = "blanca";
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
	
	
	
	
	
}
