package Entidades;

public class Posicion {
	
	private char posFila;
	private int posColumna;

	public char getPosFila() {
		return posFila;
	}
	public void setPosFila(char posFila) {
		this.posFila = posFila;
	}
	public int getPosColumna() {
		return posColumna;
	}
	public void setPosColumna(int posColumna) {
		this.posColumna = posColumna;
	}
	
	public Posicion(char posFila, int posColumna) {
		this.posFila = posFila;
		this.posColumna = posColumna;
	}
	public Posicion() {
		
	}
	
	
}
