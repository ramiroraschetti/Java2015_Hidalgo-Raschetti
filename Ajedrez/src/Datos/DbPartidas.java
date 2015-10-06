package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import Entidades.Partida;
import Entidades.Pieza;
import Entidades.PiezaReina;
import Entidades.PiezaRey;


public class DbPartidas {
	
  private static ArrayList<Partida> colPartidas;
  private static ArrayList<Partida> colPartJugando;
//private static Pieza[] piezasPartida; 

	public DbPartidas(){
		colPartidas = new ArrayList<Partida>();
		colPartJugando = new ArrayList<Partida>();
	}
	
	public Partida partidaNueva(int dni1, int dni2){  //iniciar partida nueva entre 2 jugadores
		//crear la partida nueva con los datos, asignar fichas y hay q devolver la partida entera
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Partida p = new Partida(dni1, dni2);
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into partida(idPartida, jugador1, jugador2, turno, estadoPartida) values (0,?,?,?,? )", PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, p.getJugador1());
			stmt.setInt(2, p.getJugador2());
			stmt.setString(3, p.getTurno());
			stmt.setBoolean(4, p.isEstadoPartida());
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				p.setIdPartida(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FactoryConexion.getInstancia().releaseConn();
		}
		
		
		return p;
	}
	
	public boolean estadoPartida(int dni1, int dni2) {  //Devolver si la partida esta finalizaza(False) o en juego(true)
		
		return false;
	}
	
	public Partida retomarPartida(int dni1, int dni2) { //buscar la partida empezada y devolverlas completa con las 
																	//Piezas de la partida en estado true
		ResultSet rs=null;
		Statement stmt=null;
		Partida p=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select idPartida, jugador1, jugador2 from partida where ((jugador1="+dni1+") or (jugador2 = "+dni2+")) and estadoPartida = true;");
				p=new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setJugador1(rs.getInt("jugador1"));
				p.setJugador2(rs.getInt("jugador2"));
				
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
			return p;
		}
	
	
	public void busqueda(int dni){                   //buscar partidas abiertas del dni ingresado y mostrar los dni de oponentes
		ResultSet rs=null;
		Statement stmt=null;
		Partida p=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select idPartida, jugador1, jugador2 from partida where ((jugador1="+dni+") or (jugador2 = "+dni+")) and estadoPartida = true;");
			while(rs !=null && rs.next()){
				p=new Partida();
				p.setIdPartida(rs.getInt("idPartida"));
				p.setJugador1(rs.getInt("jugador1"));
				p.setJugador2(rs.getInt("jugador2"));
				colPartJugando.add(p);
			}
			System.out.println(colPartJugando);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
			
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
//				if(nombrePieza.equals("R")) p = new PiezaRey();
//				if(nombrePieza.equals("D")) p = new PiezaReina();
								
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
