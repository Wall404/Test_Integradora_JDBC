package ar.com.dbgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.dbgrid.database.Conexion;

public class AlumnoDao {

	
	public ResultSet getAllAlumnos(){
		
		Connection con = Conexion.getConnection();
		ResultSet rs = null;
        try
        {
            Statement s = con.createStatement();
            rs = s.executeQuery("select id as Legajo, Apel_Nombre as [Apellido y Nombre], dbo.fn_porcentaje_carrera(a.id) as Porcentaje from Alumno a ");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
	}
	
	public int MaxID()
    {
        Connection con = Conexion.getConnection();
        
        String q = "select MAX (ID) from ALUMNO";
        ResultSet rs = null;
        Integer valor = null;
        
        try
        {
            PreparedStatement p = con.prepareStatement(q);

            rs = p.executeQuery();
            while(rs.next())
            {
                valor = rs.getInt(1);
            }
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return valor;
    }
	
	public void agregarAlumno(String nombre)
	{
	    Connection con = Conexion.getConnection();
	    
	    String q = "insert into ALUMNO (ID, APEL_NOMBRE) values (?, ?)";
	    
	    try
        {
            PreparedStatement p = con.prepareStatement(q);
            p.setInt(1, (MaxID() + 1));
            p.setString(2, nombre);
            p.executeUpdate();
        } 
	    catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
}
