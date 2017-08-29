package ar.com.dbgrid.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.dbgrid.database.Conexion;

public class FinalesDao 
{

	public ResultSet getAllFinlasByAlumno(int idAlumno)
	{
		/*instancia de Conexion
		 * *
		 */
		Connection con = Conexion.getConnection();
		/***/
		
		String sql = "select M.ID CODIGO, DESCRIPCION, NOTA, "  
					+ "CASE WHEN NOTA >= 4 THEN 'APROBADA' ELSE 'NO APROBADA' END RESULTADO " 
					+ " FROM FINALES F INNER JOIN MATERIA M ON F.ID_MATERIA = M.ID " 
				    + "WHERE F.ID_ALUMNO = ?";
		ResultSet rs = null;
        try
        {
        	PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, idAlumno);
            rs = s.executeQuery();
        }
        catch (Exception e)
        {
            e.printStackTrace();
    	} 
    		
        return rs;
	
	}
	
	
	public int borrarFinal(int idAlumno, int idMateria, BigDecimal nota)
	{
		Connection con = Conexion.getConnection();
		String sql = "DELETE FROM FINALES " 
				    + "WHERE ID_ALUMNO = ? " 
				    + " AND ID_MATERIA = ? "
				    + " AND NOTA = ? ";

		int r = 0;
        try
        {
        	PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, idAlumno);
            s.setInt(2, idMateria);
            s.setBigDecimal(3, nota);
            
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
	
	public ResultSet mostrarFinales(int ID_ALUMNO)
	{
		Connection con = Conexion.getConnection();
		
		String sql = "select * from MATERIA ";
		
		ResultSet r = null;				
		try 
		{
			PreparedStatement p = con.prepareStatement(sql);

			
			r = p.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public void agregarFinal(int ID, int idAlumno, int ID_Materia, BigDecimal nota)
	{
	    Connection con = Conexion.getConnection();
	    String q = "select ID from MATERIA where MATERIA.DESCRIPCION = ?";
	    String query = "INSERT INTO FINALES (ID, ID_ALUMNO, ID_MATERIA, NOTA) VALUES(?, ? , ?, ?)";
	    ResultSet r = null;
	    try
	    {
	        
	        PreparedStatement p = con.prepareStatement(query);
	        p.setInt(1, ID);
	        p.setInt(2, idAlumno);
	        p.setInt(3, ID_Materia);
	        p.setBigDecimal(4, nota);

	        p.executeUpdate();
	    } 
	    catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
	
	public ResultSet totalRegistros()
	{
	    Connection con = Conexion.getConnection();
	    
	    String q = "select * from FINALES";
	    ResultSet r = null;
	    try
	    {
	        PreparedStatement p = con.prepareStatement(q);
	        r = p.executeQuery();
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
        return r;
	}
}
