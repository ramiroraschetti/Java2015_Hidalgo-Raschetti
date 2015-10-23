package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Datos.FactoryConexion;
import Entidades.Jugador;


public class DbJugadores {

	
	
	public void guardarJugador(Jugador jugador){
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into jugador(dni, nombre, apellido) values (?,?,?)");
			
			stmt.setInt(1, jugador.getDni());
			stmt.setString(2, jugador.getNombre());
			stmt.setString(3, jugador.getApellido());
			
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
	
	
}
