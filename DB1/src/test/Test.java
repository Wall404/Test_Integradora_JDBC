package test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Conexion;

public class Test {

	public static void main(String[] args)
	{
		Connection con = Conexion.getConnection();
		
		if(con != null)
		{
			System.out.println("Conexion existosa");
		}
		/********************/
		int ID_Alumno = 3;
		BigDecimal NOTA = new BigDecimal(5);
		
		/* query que muestre ID_ALUMNO; descripcion y nota
		*/
		
		/*
		String query = "select F.ID_ALUMNO AS ALUMNO, M.DESCRIPCION, F.NOTA "
				+ "from FINALES F inner join MATERIA M "
				+ "on F.ID_MATERIA = M.ID "
				+ "WHERE F.ID_ALUMNO = ? AND F.NOTA >= ?";
		
		try 
		{
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1, ID_Alumno);
			p.setBigDecimal(2, nota);
			
			ResultSet rs = p.executeQuery();
			
			while(rs.next())
			{
				System.out.println("ID_ALUMNO: " + rs.getInt("ALUMNO")
				+ " MATERIA: " + rs.getString(2) +
				" NOTA: " + rs.getBigDecimal("NOTA"));
			}
			rs.close();
			con.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		int MATERIA = 2;
		String query = "INSERT INTO FINALES (ID_ALUMNO, ID_MATERIA, NOTA, ID) VALUES(?, ? , ?, ?)";
		
		try
		{
			PreparedStatement p = con.prepareStatement(query);
			
			p.setInt(1, ID_Alumno);
			p.setInt(2, MATERIA);
			p.setBigDecimal(3, NOTA);
			p.setInt(4, 52);
			
			int r = p.executeUpdate();
			
			if(r > 0)
			{
				System.out.println("insert exitoso");
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
