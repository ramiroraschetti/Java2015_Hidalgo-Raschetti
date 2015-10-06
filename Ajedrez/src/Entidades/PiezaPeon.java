package Entidades;

public class PiezaPeon extends Pieza {
	
	public PiezaPeon(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	
	public boolean movimientoValido() {
			
		return false;
	}

}
