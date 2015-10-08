package Entidades;

public class PiezaAlfil extends Pieza {
	
	public PiezaAlfil(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setNombre('A');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaAlfil(){
		
	}
	
	public boolean movimientoValido() {
			
			return false;
		}




}
