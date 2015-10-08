package Entidades;

public class PiezaRey extends Pieza {
	
	public PiezaRey(boolean fueMovida, String color, Partida partida, Posicion posicion){
		setNombre('R');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaRey(){
		
	}

	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
		 
		 
		 if((mueveX - posColumna == 1 && mueveY - posFila == 1) || (mueveX - posColumna == 0 && mueveY - posFila == 1) || 
				 (mueveX - posColumna == 1 && mueveY - posFila == 0)) {
		 } else {
			 throw new Exception ("Movimiento invalido");
		 }
		return true;
	}
	
}
