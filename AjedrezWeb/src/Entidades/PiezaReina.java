package Entidades;

public class PiezaReina extends Pieza {
	
	public PiezaReina(boolean fueMovida, String color, Partida partida, Posicion posicion){
		setNombre('D');
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
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
	
		if(mueveX - posColumna == mueveY - posFila){
			return true;
		}
		
		if((Math.abs(mueveX - posColumna) != 0 && Math.abs(mueveY - posFila) == 0) || (Math.abs(mueveX - posColumna) == 0 && Math.abs(mueveY - posFila) != 0)) {
			return true;
		}
		return false;
	}

}
