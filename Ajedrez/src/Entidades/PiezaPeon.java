package Entidades;

public class PiezaPeon extends Pieza {
	
	public PiezaPeon(boolean fueMovida, String color, Partida partida, Posicion posicion){
		setNombre('P');
		setColor(color);
        setPartida(partida);
        setPosicion(posicion);
        setFueMovida(fueMovida);
    }
	public PiezaPeon(){
		
	}
	
	@Override
	public boolean movimientoValido(char mueveX, int mueveY, boolean movimientoCome) throws Exception {
		 super.movimientoValido(mueveX, mueveY, movimientoCome);
		 
		 int posFila = this.getPosicion().getPosFila();
		 char posColumna = this.getPosicion().getPosColumna();
		 
//		 if(movimientoCome){
//			 if(Math.abs(mueveX - posColumna) == Math.abs(mueveY - posFila) && Math.abs(mueveX - posColumna) == 1){
//				return true;
//				}
//		 } else {
//			 if(isFueMovida()){
//				 if(Math.abs(mueveX - posColumna) == 0 && Math.abs(mueveY - posFila) == 1){
//					return true;
//				 }
//			 } else {
//				 if(Math.abs(mueveX - posColumna) == 0 && (Math.abs(mueveY - posFila) == 2 || Math.abs(mueveY - posFila) == 1)){
//					return true;
//					}
//			 }
//		 }
		 
		 if(getColor().equalsIgnoreCase("blanca")){
			 if(movimientoCome){
				 if(mueveX - posColumna == mueveY - posFila && mueveX - posColumna == 1){
					return true;
					}
			 } else {
				 if(isFueMovida()){
					 if(mueveX - posColumna == 0 && mueveY - posFila == 1){
						return true;
					 }
				 } else {
					 if(mueveX - posColumna == 0 && (mueveY - posFila == 2 || mueveY - posFila == 1)){
						return true;
						}
				 } 
			 } 
		 } 
		 if(getColor().equalsIgnoreCase("negra")){
			 if(movimientoCome){
				 if(mueveX - posColumna == mueveY - posFila && mueveX - posColumna == -1){
					return true;
					}
			 } else {
				 if(isFueMovida()){
					 if(mueveX - posColumna == 0 && mueveY - posFila == -1){
						return true;
					 }
				 } else {
					 if(mueveX - posColumna == 0 && (mueveY - posFila == -2 || mueveY - posFila == -1)){
						return true;
						}
				 } 
			 } 
		 }
		 return false;
	}


}
