package Entidades;

public class PiezaTorre extends Pieza {	
	
	public PiezaTorre(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setNombre('T');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	
	public PiezaTorre(){
		
	}
	
	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
		 
		if((Math.abs(mueveX - posColumna) != 0 && Math.abs(mueveY - posFila) == 0) || (Math.abs(mueveX - posColumna) == 0 && Math.abs(mueveY - posFila) != 0)) {
			return true;
		}
		
		return false;
	}

}
