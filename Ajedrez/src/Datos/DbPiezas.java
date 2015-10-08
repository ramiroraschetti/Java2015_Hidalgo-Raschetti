package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.*;

public class DbPiezas{
	
	public ArrayList<Pieza> buscarPiezas(Partida partida){
		
		ArrayList<Pieza> piezas = new ArrayList<Pieza>();
		Posicion pos= null;
		Pieza p= null;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from pieza where idPartida_Pieza = ? and estadoPieza = true");
			stmt.setInt(1, partida.getIdPartida());
			
			rs = stmt.executeQuery();
			while(rs !=null && rs.next()){
				
				pos = new Posicion(rs.getString("posColumna").charAt(0), rs.getInt("posFila"));
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
				p.setIdPieza(rs.getInt("idPieza"));
				p.setNombre(rs.getString("nombre").charAt(0));
				p.setColor(rs.getString("color"));
				p.setEstadoPieza(rs.getBoolean("estadoPieza"));
				p.setFueMovida(rs.getBoolean("fueMovida"));
				p.setPosicion(pos);
				p.setPartida(partida);
				
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
	
	public void guardarPiezas(Partida partida){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<Pieza> listapiezas = new ArrayList<Pieza>();
		try {

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into pieza (idPieza, nombre, color, posColumna, posFila, estadoPieza, fueMovida, idPartida_Pieza) values (0,?,?,?,?,?,?,?)");
			listapiezas = partida.getPiezasPartida();
			for(Pieza pie:listapiezas ){				
				stmt.setString(1, String.valueOf(pie.getNombre()));
				stmt.setString(2, pie.getColor());
                stmt.setString(3, String.valueOf(pie.getPosicion().getPosColumna()));
                stmt.setInt(4, pie.getPosicion().getPosFila());
				stmt.setBoolean(5, pie.isEstadoPieza());
				stmt.setBoolean(6, pie.isFueMovida());
				stmt.setInt(7, partida.getIdPartida());
				
				stmt.execute();
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
	}
					

	
	public void updatePiezas(Partida partida){ 
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<Pieza> listapiezas = new ArrayList<Pieza>();
		try {

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"update pieza set  idPieza=?, posColumna=?, posFila=?, estadoPieza=?, fueMovida=?  where idPartida_Pieza=?"
				   );
			listapiezas = partida.getPiezasPartida();
		
			for(Pieza pie:listapiezas ){				
				stmt.setInt(1, pie.getIdPieza());
                stmt.setString(2, String.valueOf(pie.getPosicion().getPosColumna()));
                stmt.setInt(3, pie.getPosicion().getPosFila());
				stmt.setBoolean(4, pie.isEstadoPieza());
				stmt.setBoolean(5, pie.isFueMovida());
				stmt.setInt(6, partida.getIdPartida());
				stmt.execute();
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
	}

}