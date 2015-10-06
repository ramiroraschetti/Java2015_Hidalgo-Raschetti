package Entidades;

public class PiezaRey extends Pieza {
	
	public PiezaRey(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }

	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 char posFila = this.getPosicion().getPosFila();
		 int posColumna = this.getPosicion().getPosColumna();
		 
		 if((mueveX - posFila == 1 && mueveY - posColumna == 1) || (mueveX - posFila == 0 && mueveY - posColumna == 1) || 
				 (mueveX - posFila == 1 && mueveY - posColumna == 0)) {
			 return true;
		 } else {
			 throw new Exception ("Movimiento invalido");
		 }
	}
	
	

}
