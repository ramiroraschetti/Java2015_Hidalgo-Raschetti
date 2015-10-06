package Entidades;

public class PiezaCaballo extends Pieza{
	
	public PiezaCaballo(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	
	public boolean movimientoValido() {
			
		return false;
	}

}
