package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



import Entidades.Partida;
import Entidades.Pieza;
import Entidades.PiezaReina;
import Entidades.PiezaRey;


public class DbPartidas {
	
//private static ArrayList<Partida> colPartidas;
//private static ArrayList<Partida> colPartJugando;
//private static Pieza[] piezasPartida; 

	public DbPartidas(){

	}
	
	public Partida partidaNueva(int dni1, int dni2){  //iniciar partida nueva entre 2 jugadores
		//crear la partida nueva con los datos, asignar fichas y hay q devolver la partida entera
		Partida p = new Partida();
		
		return p;
	}
	
	public boolean estadoPartida(int dni1, int dni2) {  //Devolver si la partida esta finalizaza(False) o en juego(true)
		
		return false;
	}
	
	public Partida retomarPartida(int dni1, int dni2) { //buscar la partida empezada y devolverlas completa con las 
																	//Piezas de la partida en estado true
		Partida p = new Partida();
		
		return p;
	}
	
	
	public void busqueda(int dni){                   //buscar partidas abiertas del dni ingresado y mostrar los dni de oponentes

			
		}

	public Pieza[] getPiezas() {
		Pieza[] piezas= new Pieza[32];
		ResultSet rs=null;
		Statement stmt=null;
		
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from pieza;");
			int i=0;
			while(rs.next()) {
				Pieza p = null;
				String nombrePieza = rs.getString(2);
				if(nombrePieza.equals("R")) p = new PiezaRey();
				if(nombrePieza.equals("D")) p = new PiezaReina();
								
				p.setIdPieza(rs.getInt(1));
				p.setColor(rs.getString(3));
				piezas[i]=p;
				i++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		FactoryConexion.getInstancia().releaseConn();
		return piezas;
	}

	

	

}
