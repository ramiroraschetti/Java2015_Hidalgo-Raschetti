package Entidades;

public class Posicion {
	
	private char posColumna;
	private int posFila;

	public char getPosFila() {
		return posColumna;
	}
	public void setPosFila(char posFila) {
		this.posColumna = posFila;
	}
	public int getPosColumna() {
		return posFila;
	}
	public void setPosColumna(int posColumna) {
		this.posFila = posColumna;
	}
	public String toString(){
		return  ""+this.getPosColumna()+this.getPosFila();
	}

	
	public Posicion(char posFila, int posColumna) {
		this.posColumna = posFila;
		this.posFila = posColumna;
	}
	public Posicion() {
		
	}
	
	
}
