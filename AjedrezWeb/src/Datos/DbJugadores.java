package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.FactoryConexion;
import Entidades.Jugador;
import Entidades.Partida;


public class DbJugadores {

	
	
	public void guardarJugador(int dni, String nombre, String apellido){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into jugador(dni, nombre, apellido) values (?,?,?)");
			
			stmt.setInt(1, dni);
			stmt.setString(2,nombre);
			stmt.setString(3, apellido);
			
			stmt.execute();

						
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
	}
	
	public Jugador buscarJugador(int dni){
		Jugador j= null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from jugador where dni=?");
		
			stmt.setInt(1, dni);
			
			rs = stmt.executeQuery();															
			if(rs !=null && rs.next()){
				j = new Jugador();
				j.setDni(rs.getInt("dni")); 
				j.setNombre(rs.getString("nombre"));
				j.setApellido(rs.getString("apellido"));
								
			}
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
		
		return j;
		
	}
	
	
}
