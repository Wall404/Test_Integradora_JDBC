package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Alumno;

public class AlumnoService 
{
		public Alumno getAlumno(int id_alumno)
		{
			Connection con = Conexion.getConnection();
			Alumno alumno = null;
			String queryStr = "SELECT APEL_NOMBRE FROM ALUMNO WHERE ID=?";
			try
			{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setInt(1, id_alumno);
				   ResultSet rs = ps.executeQuery();
				   while (rs.next())
				   {
					   alumno = new Alumno();
					   alumno.setId_alumno(id_alumno);
					   alumno.setApel_nombre(rs.getString("APEL_NOMBRE"));
				   }

				   rs.close();
				   ps.close();

			}catch(Exception e){
				System.out.println("Error en la ejecución de la sentencia SQL:\n" + e.getMessage());
			}	
			finally
			{
				if (con != null)
				{
					try
					{
						con.close();
					} catch (SQLException e) {
						System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
						e.printStackTrace();
						
					}
				}		
			}
			return alumno;
			
		}
}
