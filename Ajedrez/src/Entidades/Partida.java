package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Partida {

	private int idPartida;
	private Jugador jugador1, jugador2;
	private String turno = "blanca";
	private boolean estadoPartida= true; //true partida aun en juego - false partida finalizada
	private ArrayList<Pieza> piezasPartida = new ArrayList<Pieza>();
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Jugador getJugadorBlancas() {
		return jugador1;
	}
	public void setJugadorBlancas(Jugador jugadorBlancas) {
		this.jugador1 = jugadorBlancas;
	}
	public Jugador getJugadorNegras() {
		return jugador2;
	}
	public void setJugadorNegras(Jugador jugadorNegras) {
		this.jugador2 = jugadorNegras;
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
	
	public Partida(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
				
	}
	
	
	public void cambiarTurno(){
        if (Objects.equals(turno, "blanco")) 
        		turno="negro"; 
        	else turno="blanco";
    }
	
	
	
	
	
}
