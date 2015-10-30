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
		 
		 
		 if((Math.abs(mueveX - posColumna) == 1 && Math.abs(mueveY - posFila) == 1) || (Math.abs(mueveX - posColumna) == 0 && Math.abs(mueveY - posFila) == 1) || 
				 (Math.abs(mueveX - posColumna) == 1 && Math.abs(mueveY - posFila) == 0)) {
		 } else {
			 throw new Exception ("Movimiento invalido");
		 }
		return true;
	}
	
}
