package Entidades;

public abstract class Pieza {

	private int idPieza;
	private char nombre;
	private String color;
	private Posicion posicion;
	private Jugador jugador;
	private boolean estadoPieza = true; //Si la pieza fue comida el estado es false, si esta en el tablero es true
	private Partida partida;
	private boolean fueMovida = false;
	
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
	
		

	public abstract void moverPieza(char mueveX, int mueveY);
	
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 if (!(mueveX>='a' && mueveX<='h') || !(mueveY>=1 && mueveY<=8)) {
	            throw new Exception("Pieza out of bound");
	        }
		 
		 char posX = getPosicion().getPosFila();
	        int posY = getPosicion().getPosColumna();
	        if (posX == mueveX && posY == mueveY) throw new Exception("La pieza ya se encuentra en esa posicion");

		 return true;
	};
	
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public boolean isFueMovida() {
		return fueMovida;
	}
	public void setFueMovida(boolean fueMovida) {
		this.fueMovida = fueMovida;
	}
	
}
