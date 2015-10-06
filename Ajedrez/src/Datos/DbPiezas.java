package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.*;

public class DbPiezas{
	
	//Recuperar de la DB todas las piezas de la partida
	public ArrayList<Pieza> buscarPiezas(int idPartida, String color){
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select nombre, color, estado, posicion from piezas where idPartida = ?, color = ?");
			stmt.setInt(1, idPartida);
			stmt.setString(2, color);
			rs = stmt.executeQuery();
			while(rs !=null && rs.next()){
				Pieza p = null;
				switch (rs.getString("nombre")) {
				case "P":
					p = new PiezaPeon();					
					break;
					
				case "T":
					p = new PiezaTorre();
					break;
					
				case "A":
					p = new PiezaAlfil();
					break;
					
				case "C":
					p = new PiezaCaballo();
					break;
					
				case "R":
					p = new PiezaRey();
					break;
					
				case "D":
					p = new PiezaReina();
					break;

				default:
					break;
				}
				p.setColor(rs.getString("color"));
				p.setEstadoPieza(rs.getBoolean("estadoPieza"));
			//	p.setNombre(rs.getString("nombre"));
				
				piezas.add(p);
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

		return piezas;
	}
	
	
	public void guardarPiezas(Pieza p, Partida partida){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try {

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into piezas(idPartida, nombre, color, estado, posicion values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS
				   );
			
			stmt.setInt(1, partida.getIdPartida());
		//	stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getColor());
			stmt.setBoolean(4, p.isEstadoPieza());
		//	stmt.setString(5, p.getPosicion());
			
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