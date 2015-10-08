package Entidades;

public class PiezaAlfil extends Pieza {
	
	public PiezaAlfil(boolean fueMovida, String color, Partida partida, Posicion posicion){
        setNombre('A');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaAlfil(){
		
	}
	
	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
	
		if(Math.abs(mueveX - posColumna) == Math.abs(mueveY - posFila)){
			return true;
		}
		
			return false;
		}




}
