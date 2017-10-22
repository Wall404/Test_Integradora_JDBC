package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.dbgrid.database.Conexion;
import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.Final;



public class FinalesService 
{

		public ArrayList<Final> getFinalesByAlumno(Alumno alumno)
		{
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT " 
					          + "	F.ID as ID "
					          + ", 	A.APEL_NOMBRE "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M "
					          + "WHERE"
					          
					          + "	A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          +	"	AND F.ID_ALUMNO = ? "
					          + "ORDER BY " 
					          + "	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try
			{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setInt(1, alumno.getId_alumno());
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next())
				   {
					   f = new Final();
					   f.setId(rs.getInt("ID"));
					   f.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   f.setId_materia(rs.getInt("ID_MATERIA"));
					   f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
					   f.setNota(rs.getFloat("NOTA"));
					   f.setDeleteURL("./borrarFinal?ID_ALUMNO=" + alumno.getId_alumno() +  
					           "&ID_MATERIA=" + rs.getInt("ID_MATERIA"));
					   resultado.add(f);
				   }
				   
				   rs.close();
				   ps.close();

			}
			catch(Exception e)
			{
				System.out.println("Error en la ejecución de la sentencia SQL:\n" + e.getMessage());
			}	
			finally
			{
				if (con != null)
				{
					try 
					{
						con.close();
					}
					catch (SQLException e) 
					{
						System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
						e.printStackTrace();
					}
				}
						
			}
			return resultado;
			
			
		}
		
		public ArrayList<Final> getFinales()
		{
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT " 
					          + "	F.ID as ID "
					          + ",  A.ID as ID_A"
					          + ",  A.APEL_NOMBRE "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M "
					          + "WHERE"					          
					          + "	A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          + "ORDER BY " 
					          + "   A.APEL_NOMBRE"
					          + ",	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try
			{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next())
				   {
					   f = new Final();
					   f.setId(rs.getInt("ID"));
					   f.setApel_nombre(rs.getString("APEL_NOMBRE"));
					   f.setId_materia(rs.getInt("ID_MATERIA"));
					   f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
					   f.setNota(rs.getFloat("NOTA"));
					   f.setDeleteURL("./borrarFinal?ID_ALUMNO=" + rs.getInt("ID_A") + "&ID_MATERIA=" + rs.getInt("ID_MATERIA"));
					   resultado.add(f);
				   }
				   
				   rs.close();
				   ps.close();

			}
			catch(Exception e)
			{
				System.out.println("Error en la ejecución de la sentencia SQL:\n" + e.getMessage());
			}	
			finally
			{
				if (con != null)
				{
					try
					{
						con.close();
					}
					catch (SQLException e) 
					{
					    System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
					    e.printStackTrace();

					}
				}

			}
			return resultado;


		}

		public ArrayList<Final> getFinalesByAlumnoAndMateria(int id_alumno, int id_materia)
		{

		    Connection con = Conexion.getConnection();

		    ArrayList<Final> resultado = new ArrayList<Final>();

		    String queryStr = "SELECT " 
		            + "   F.ID as ID "
		            + ",  A.APEL_NOMBRE "
		            + ",   M.ID AS ID_MATERIA"
		            + ",  M.DESCRIPCION AS DESCRIPCION_MATERIA"
		            + ",  F.NOTA "
		            + "FROM "  
		            + "   ALUMNO A, FINALES F, MATERIA M "
		            + "WHERE"

                              + "   A.ID = F.ID_ALUMNO "
                              + "   AND F.ID_MATERIA=M.ID "
                              + "   AND F.ID_ALUMNO = ? "
                              + "   AND F.ID_MATERIA = ? "
                              + "ORDER BY " 
                              + "   M.DESCRIPCION" 
                              + "   , F.NOTA";


		    try
		    {
		        PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ps.setInt(1, id_alumno);
		        ps.setInt(2, id_materia);
		        ResultSet rs = ps.executeQuery();

		        Final f=null;
		        while (rs.next())
		        {
		            f = new Final();
		            f.setId(rs.getInt("ID"));
		            f.setApel_nombre(rs.getString("APEL_NOMBRE"));
		            f.setId_materia(rs.getInt("ID_MATERIA"));
		            f.setDescripcion_materia(rs.getString("DESCRIPCION_MATERIA"));
		            f.setNota(rs.getFloat("NOTA"));
		            resultado.add(f);
		        }

		        rs.close();
		        ps.close();

		    }catch(Exception e){
		        System.out.println("Error en la ejecución de la sentencia SQL:\n" + e.getMessage());
		    }   
		    finally{
		        if (con != null)
		        {
		            try 
		            {
		                con.close();
		            } catch (SQLException e)
		            {
		                System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
		                e.printStackTrace();

		            }
		        }

		    }
		    return resultado;


		}
		
		public int borrarFinal(int idAlumno, int idMateria)
	    {
	        Connection con = Conexion.getConnection();
	        String sql = "DELETE FROM FINALES " 
	                    + "WHERE ID_ALUMNO = ? " 
	                    + " AND ID_MATERIA = ? ";

	        int r = 0;
	        try
	        {
	            PreparedStatement s = con.prepareStatement(sql);
	            s.setInt(1, idAlumno);
	            s.setInt(2, idMateria);
	            
	            r = s.executeUpdate();
	        } catch (Exception e)
	        {
	            r = 0;
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            try 
	            {
	                con.close();
	            } catch (SQLException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        return r;
	    }

}
