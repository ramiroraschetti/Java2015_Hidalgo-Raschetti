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
	public void setterPosicion(String colfil){
		this.posColumna= colfil.charAt(0);
		this.posFila= Integer.valueOf(colfil.substring(1, 2));
	}

	
	public Posicion(char posColumna1, int posFila) {
		this.posColumna = posColumna1;
		this.posFila = posFila;
	}
	public Posicion() {
		
	}
	
	
}
