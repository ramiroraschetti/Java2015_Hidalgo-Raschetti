package Entidades;

public class Partida {

	private int idPartida;
	private int jugBlanca, jugNegra;
	private Pieza fichas;
	
	
	public int getId() {
		return idPartida;
	}
	public void setId(int id) {
		this.idPartida = id;
	}
	public int getJugBlanca() {
		return jugBlanca;
	}
	public void setJugBlanca(int jugBlanca) {
		this.jugBlanca = jugBlanca;
	}
	public int getJugNegra() {
		return jugNegra;
	}
	public void setJugNegra(int jugNegra) {
		this.jugNegra = jugNegra;
	}
	public Pieza getFichas() {
		return fichas;
	}
	public void setFichas(Pieza fichas) {
		this.fichas = fichas;
	}
	public Partida(int idPartida, int jugBlanca, int jugNegra) {
		super();
		this.idPartida = idPartida;
		this.jugBlanca = jugBlanca;
		this.jugNegra = jugNegra;
	}
	
	public String toString(){
		return "\nID: "+String.valueOf(this.getId()) +"\n"+ "Contrincante Dni: "+String.valueOf(this.getJugNegra());
	}
	
	
	
}
