package Entidades;

public class PiezaAlfil extends Pieza {
	
	public PiezaAlfil(boolean fueMovida, String color, Partida partida, Posicion posicion){
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

	public void moverPieza() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public void moverPieza(char mueveX, int mueveY) {
		// TODO Auto-generated method stub
		
	}

}
