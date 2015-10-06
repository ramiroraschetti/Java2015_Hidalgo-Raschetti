package Entidades;

public class PiezaTorre extends Pieza {	
	
	public PiezaTorre(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	
	public boolean movimientoValido() {
		
		return false;
	}

}
