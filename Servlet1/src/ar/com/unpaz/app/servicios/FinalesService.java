package ar.com.unpaz.app.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.unpaz.app.database.Conexion;
import ar.com.unpaz.app.modelo.Final;
import ar.com.unpaz.app.modelo.Usuario;



public class FinalesService {

		public ArrayList<Final> getFinalesByUsuario(Usuario usuario){
			
			Connection con = Conexion.getConnection();
			
			ArrayList<Final> resultado = new ArrayList<Final>();
			
			String queryStr = "SELECT " 
					          + "	F.ID as ID "
					          + ",   M.ID AS ID_MATERIA"
					          + ", 	M.DESCRIPCION AS DESCRIPCION_MATERIA"
					          + ",	F.NOTA "
					          + "FROM "  
					          + "	ALUMNO A, FINALES F, MATERIA M, ALUMNO_USUARIO AU "
					          + "WHERE"
					          + "   AU.ID_ALUMNO = A.ID  "
					          + "	AND A.ID = F.ID_ALUMNO "
					          + "	AND F.ID_MATERIA=M.ID "
					          +	"	AND AU.USUARIO = ? "
					          + "ORDER BY " 
					          + "	M.DESCRIPCION" 
					          +	"	, F.NOTA";
			
			
			try{
				   PreparedStatement ps = con.prepareStatement(queryStr, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				   ps.setString(1, usuario.getUsr());
				   ResultSet rs = ps.executeQuery();
				   
				   Final f=null;
				   while (rs.next()){
					   f = new Final();
					   f.setId(rs.getInt("ID"));
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
				if (con != null){
					try {
						con.close();
					} catch (SQLException e) {
						System.out.println("login: Error al cerrar la conexion: " + e.getMessage());
						e.printStackTrace();
						
					}
				}
						
			}
			return resultado;
			
			
		}
}
