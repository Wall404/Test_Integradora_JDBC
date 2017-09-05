package ar.com.dbgrid.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.dbgrid.database.Conexion;
import ar.com.dbgrid.modelo.Final;

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
	
	//modificar para que reciba objeto Final
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
		int nota = 4;
		String sql = "select m.DESCRIPCION from (select * from MATERIA) m "
		        + "where m.ID not in (select f.ID_MATERIA from FINALES f "
		        + "where f.ID_ALUMNO = ?)";
		        /*"select m.descripcion from MATERIA m " +
		        " join finales f on f.id_materia = m.id " +
		        " where f.id_alumno = ? and f.nota < ?";*/
		
		ResultSet r = null;				
		try 
		{
			PreparedStatement p = con.prepareStatement(sql);
			p.setInt(1, ID_ALUMNO);

			
			r = p.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public void agregarFinal(int ID, Final fa)
	{
	    Connection con = Conexion.getConnection();
	    String q = "select ID from MATERIA where MATERIA.DESCRIPCION = ?";
	    String query = "INSERT INTO FINALES (ID, ID_ALUMNO, ID_MATERIA, NOTA) VALUES(?, ? , ?, ?)";
	    try
	    {
	        
	        PreparedStatement p = con.prepareStatement(query);
	        p.setInt(1, ID);
	        p.setInt(2, fa.getId_alumno());
	        p.setInt(3, fa.getId_materia());
	        p.setBigDecimal(4, fa.getNota());

	        p.executeUpdate();
	    } 
	    catch (SQLException e)
        {
            e.printStackTrace();
        }
	}
	
	public int idMateria(String descripcion)
	{
	    Connection con = Conexion.getConnection();
	    
	    String q = "select m.id from MATERIA m\r\n " + 
	            "join FINALES f on f.ID_MATERIA = m.ID\r\n " + 
	            "where m.DESCRIPCION like ? ";
	    ResultSet r = null;
	    Integer valor = null;
	    try
	    {
	        PreparedStatement p = con.prepareStatement(q);
	        p.setString(1, descripcion);
	        r = p.executeQuery();
	        while(r.next())
	        {
	            valor = r.getInt(1);
	        }
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
        return valor;
	}
	
	public int MaxID()
	{
	    Connection con = Conexion.getConnection();
	    
	    String q = "select MAX (ID) from FINALES";
	    ResultSet rs = null;
	    Integer valor = null;
	    
	    try
        {
            PreparedStatement p = con.prepareStatement(q);
            //p.setString(1, "ID");
            rs = p.executeQuery();
            while(rs.next())
            {
                valor = rs.getInt(1);
            }
        } 
	    catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return valor;
	}
}
