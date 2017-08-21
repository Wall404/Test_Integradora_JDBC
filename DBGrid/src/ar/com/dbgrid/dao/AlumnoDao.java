package ar.com.dbgrid.dao;

import java.sql.Connection;
import java.sql.ResultSet;
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
}
