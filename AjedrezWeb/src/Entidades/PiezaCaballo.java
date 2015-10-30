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

	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
	
		if((Math.abs(mueveX - posColumna) == 2 && Math.abs(mueveY - posFila) == 1) || (Math.abs(mueveX - posColumna) == 1 && Math.abs(mueveY - posFila) == 2)) {
			return true;
		}
		
			return false;
		}

}
