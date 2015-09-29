package Entidades;

public abstract class Pieza {

	private int idPieza;
	private char nombre;
	private String color;
	private Posicion posicion;
	private Jugador jugador;
	private boolean estadoPieza = true; //Si la pieza fue comida el estado es false, si esta en el tablero es true
	
	public int getIdPieza() {
		return idPieza;
	}
	public void setIdPieza(int idPieza) {
		this.idPieza = idPieza;
	}
	public char getNombre() {
		return nombre;
	}
	public void setNombre(char nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isEstadoPieza() {
		return estadoPieza;
	}
	public void setEstadoPieza(boolean estadoPieza) {
		this.estadoPieza = estadoPieza;
	}
	
		
	public abstract boolean movimientoValido();
	public abstract void moverPieza();
}
