package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Partida {

	private int idPartida;
	private Jugador jugador1, jugador2;
	private String turno = "blanca"; //kike: hay que definir BLANCA o BLANCO, fijate el metodo
	private boolean estadoPartida= true; //true partida aun en juego - false partida finalizada
	private ArrayList<Pieza> piezasPartida = new ArrayList<Pieza>();
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public boolean isEstadoPartida() {
		return estadoPartida;
	}
	public void setEstadoPartida(boolean estadoPartida) {
		this.estadoPartida = estadoPartida;
	}
	public ArrayList<Pieza> getPiezasPartida() {
		return piezasPartida;
	}
	public void setPiezasPartida(ArrayList<Pieza> piezasPartida) {
		this.piezasPartida = piezasPartida;
	}
	
	public Partida(){
		iniciarPiezas();
	}
	
	
	public Partida(Jugador jug1, Jugador jug2) {
		this.jugador1= jug1;
		this.jugador2=jug2;
		this.turno="blanca";
		this.estadoPartida=true;
		iniciarPiezas();
	}
	public void iniciarPiezas(){
		Posicion posicion;
		// inicializar el tablero
        posicion = new Posicion('a', 1);
        this.piezasPartida.add(new PiezaTorre(false, "blanca", this, posicion));
        posicion = new Posicion('b', 1);
        this.piezasPartida.add(new PiezaCaballo(false, "blanca", this, posicion));
        posicion = new Posicion('c', 1);
        this.piezasPartida.add(new PiezaAlfil(false, "blanca", this, posicion));
        posicion = new Posicion('d', 1);
        this.piezasPartida.add(new PiezaRey(false, "blanca", this, posicion));
        posicion = new Posicion('e', 1);
        this.piezasPartida.add(new PiezaReina(false, "blanca", this, posicion));
        posicion = new Posicion('f', 1);
        this.piezasPartida.add(new PiezaAlfil(false, "blanca", this, posicion));
        posicion = new Posicion('g', 1);
        this.piezasPartida.add(new PiezaCaballo(false, "blanca", this, posicion));
        posicion = new Posicion('h', 1);
        this.piezasPartida.add(new PiezaTorre(false, "blanca", this, posicion));
        
        posicion = new Posicion('a', 8); 
        this.piezasPartida.add(new PiezaTorre(false, "negra", this, posicion));
        posicion = new Posicion('b', 8);
        this.piezasPartida.add(new PiezaCaballo(false, "negra", this, posicion));
        posicion = new Posicion('c', 8);
        this.piezasPartida.add(new PiezaAlfil(false, "negra", this, posicion));
        posicion = new Posicion('d', 8);
        this.piezasPartida.add(new PiezaRey(false, "negra", this, posicion));
        posicion = new Posicion('e', 8);
        this.piezasPartida.add(new PiezaReina(false, "negra", this, posicion));
        posicion = new Posicion('f', 8);
        this.piezasPartida.add(new PiezaAlfil(false, "negra", this, posicion));
        posicion = new Posicion('g', 8);
        this.piezasPartida.add(new PiezaCaballo(false, "negra", this, posicion));
        posicion = new Posicion('h', 8);
        this.piezasPartida.add(new PiezaTorre(false, "negra", this, posicion));
        for (char x = 'a'; x <='h'; x++){
            posicion = new Posicion(x, 2);
            this.piezasPartida.add(new PiezaPeon(false, "blanca", this, posicion));

            posicion = new Posicion(x, 7);
            this.piezasPartida.add(new PiezaPeon(false, "negra", this, posicion));
        }
        
    }
				
	public String toString(){
		return "Partida:"+String.valueOf(this.getIdPartida())+"\nJugador 1:"+this.getJugador1()+"\nJugador 2:"+this.getJugador2()+"\n";
	}
	
	
	public void cambiarTurno(){
        if (Objects.equals(turno, "blanca")) 
        		turno="negra"; 
        	else turno="blanca";
    }
	
	

	public void moverPieza(char mueveX, int mueveY, char posX, int posY) throws Exception { //mueve destino - pos origen ?
		Posicion posicion = new Posicion(posX, posY);
		Posicion posicionHacia = new  Posicion(mueveX, mueveY);
		Pieza piezaElegida = null;
		Pieza piezaAComer = null;
		boolean movimientoCome = false;
		
		//Buscamos la pieza a mover, la pieza a comer, y validamos que no este ocupada por una del mismo color
		for(Pieza pieza : getPiezasPartida()){
			if(pieza.isEstadoPieza() == true){
				if(pieza.getPosicion().getPosColumna() == (posicion.getPosColumna()) && (pieza.getPosicion().getPosFila() == posicion.getPosFila())
						&& this.getTurno().equals(pieza.getColor())){
					piezaElegida = pieza;
				} 
				if(posicionHacia.getPosColumna() == (pieza.getPosicion().getPosColumna()) && posicionHacia.getPosFila() == pieza.getPosicion().getPosFila()){
					if(pieza.getColor().equals(getTurno())){
						throw new Exception("La posicion a mover se encuentra ocupada por una pieza del mismo color");
					} else {
						movimientoCome = true;
						piezaAComer = pieza;
					}
				}					
			}
		}
		
		if(piezaElegida == null){
			throw new Exception("No hay pieza de tu color en la posicion Origen");
		}
		
		
		if(piezaElegida.movimientoValido(mueveX, mueveY, movimientoCome)){
			if(piezaAComer != null){
				piezaAComer.setEstadoPieza(false);
				if(piezaAComer.getNombre() == 'R'){
					this.setEstadoPartida(false);
				}
			}
			piezaElegida.setPosicion(posicionHacia);
			this.cambiarTurno();
			
		};
		
		//TODO: cambiar el estado de la pieza comida, sacarla del juego, cambiar de turnoss
	}


	
}
	

