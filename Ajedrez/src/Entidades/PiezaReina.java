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
		return false;
	}

}
