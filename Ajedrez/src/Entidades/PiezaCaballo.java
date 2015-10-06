package Entidades;

public class PiezaCaballo extends Pieza{
	
	public PiezaCaballo(boolean fueMovida, String color, Partida partida, Posicion posicion){
		setNombre('C');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaCaballo(){
		
	}
	public boolean movimientoValido() {
			
		return false;
	}

}
