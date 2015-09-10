package Datos;

import java.util.ArrayList;


import Entidades.Partida;


public class DbPartidas {
	
private static ArrayList<Partida> colPartidas;
private static ArrayList<Partida> colPartJugando;
private int contId=2;

	public DbPartidas(){
		colPartidas = new ArrayList<Partida>();
		Partida e = new Partida(1,12345678,33098016);
		colPartidas.add(e);
	}
	
	public void add(int dniB, int dniN){
		Partida p = new Partida(contId , dniB, dniN);
		contId++;
		colPartidas.add(p);
	}
	
	public void busqueda(int dni){
		colPartJugando = new ArrayList<Partida>();

			for (Partida partida : colPartidas) {
				if (partida.getJugBlanca() == dni){
					colPartJugando.add(partida);
				}
			}
			System.out.println(colPartJugando);
			
		}
	

}
