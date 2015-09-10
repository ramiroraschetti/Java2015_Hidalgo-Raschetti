package Controlador;


import Datos.DbPartidas;

public class CtrlJugar {

	private DbPartidas catalogo;
	
	public CtrlJugar(){
		catalogo = new DbPartidas();
	}
	
	public  void iniciarPartida(int dniBlancas, int dniNegras) {
		catalogo.add(dniBlancas, dniNegras);
	}

	public  void buscarOponente(int dniB) {
		
		catalogo.busqueda(dniB);
	}

}
