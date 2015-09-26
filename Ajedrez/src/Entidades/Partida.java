package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Partida {

	private int idPartida;
	private Jugador jugadorBlancas, jugadorNegras;
	private String turno = "blanca";
	ArrayList<Pieza> piezasPartida = new ArrayList<Pieza>();
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Jugador getJugadorBlancas() {
		return jugadorBlancas;
	}
	public void setJugadorBlancas(Jugador jugadorBlancas) {
		this.jugadorBlancas = jugadorBlancas;
	}
	public Jugador getJugadorNegras() {
		return jugadorNegras;
	}
	public void setJugadorNegras(Jugador jugadorNegras) {
		this.jugadorNegras = jugadorNegras;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
		public ArrayList<Pieza> getPiezasPartida() {
		return piezasPartida;
	}
	public void setPiezasPartida(ArrayList<Pieza> piezasPartida) {
		this.piezasPartida = piezasPartida;
	}
	
	
	public Partida() {}
	
	public Partida(Jugador jugadorBlancas, Jugador jugadorNegras) {
		this.jugadorBlancas = jugadorBlancas;
		this.jugadorNegras = jugadorNegras;
		colocarFichas();
	}
	
	public void colocarFichas(){
		
		for (char x = 'a'; x <= 'h'; x++){
			PiezaPeon peon = new PiezaPeon();
			peon.setPosicion(new Posicion(x, 2));
			peon.setJugador(getJugadorBlancas());
			piezasPartida.add(peon);
		}
		
		PiezaTorre torre1 = new PiezaTorre();
		torre1.setPosicion(new Posicion('a',1));
		torre1.setJugador(getJugadorBlancas());
		piezasPartida.add(torre1);
		
		PiezaTorre torre2 = new PiezaTorre();
		torre2.setPosicion(new Posicion('h',1));
		torre2.setJugador(getJugadorBlancas());
		piezasPartida.add(torre2);
		
		PiezaCaballo caballo1 = new PiezaCaballo();
		caballo1.setPosicion(new Posicion('g', 1));
		caballo1.setJugador(getJugadorBlancas());
		piezasPartida.add(caballo1);
		
		
		
		PiezaAlfil alfil1 = new PiezaAlfil();
		
	}
	
	public void cambiarTurno(){
        if (Objects.equals(turno, "blanco")) 
        		turno="negro"; 
        	else turno="blanco";
    }
	
	
	
	
}
