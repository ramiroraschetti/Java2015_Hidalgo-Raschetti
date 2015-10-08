package Entidades;

public class Posicion {
	
	private char posColumna;
	private int posFila;


	public char getPosColumna() {
		return posColumna;
	}
	public void setPosColumna(char posColumna) {
		this.posColumna = posColumna;
	}
	public int getPosFila() {
		return posFila;
	}
	public void setPosFila(int posFila) {
		this.posFila = posFila;
	}
	public String toString(){
		return  String.valueOf(this.getPosColumna()+this.getPosFila());
	}


	
	public Posicion(char posColumna, int posFila) {
		this.posColumna = posColumna;
		this.posFila = posFila;
	}
	public Posicion() {
		
	}
	
	
}
