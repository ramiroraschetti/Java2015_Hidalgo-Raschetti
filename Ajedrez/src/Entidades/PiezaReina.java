package Entidades;

public class PiezaReina extends Pieza {
	
	public PiezaReina(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaReina(){
		
	}
	
	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 char posFila = this.getPosicion().getPosFila();
		 int posColumna = this.getPosicion().getPosColumna();
		return false;
	}

}
