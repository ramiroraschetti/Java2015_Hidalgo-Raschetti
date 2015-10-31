package Entidades;

import java.util.ArrayList;

public class Jugador {

	private int dni;
	private String nombre, apellido;
	ArrayList<Partida> partidasPendientes ;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Jugador(int dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public Jugador (int dni){
		this.dni=dni;
	}
	
	public Jugador (){
		
	}
	public ArrayList<Partida> getPartidasPendientes() {
		return partidasPendientes;
	}
	public void setPartidasPendientes(ArrayList<Partida> partidasPendientes) {
		this.partidasPendientes = partidasPendientes;
	}
	
	public String toString(){
		return this.getDni()+"" ;
	}
	
	
}
