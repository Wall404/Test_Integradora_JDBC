package ar.com.unpaz.app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.database.Conexion;
import ar.com.unpaz.app.modelo.Final;
import ar.com.unpaz.app.modelo.Usuario;
import ar.com.unpaz.app.servicios.FinalesService;

/**
 * Servlet implementation class login
*/
@WebServlet("/Login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String usr = request.getParameter("usu_form");
		String pwd = request.getParameter("pass_form");
		String perfil = request.getParameter("perfil");
		Usuario usuario = new Usuario(usr, pwd, perfil );
		boolean validado = false;
		
		validado= validarUsuario(usuario);
		if (!validado) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
		
			out.println("<body>");
			out.println("<h1>Los datos no son validos para ingresar al sistema</h1>");
			out.println("<a href=./Bienvenido.html>Regresar al login</a>");
			
			out.println("</body>");
			out.println("</htm>");
			
		}else {
			FinalesService fs = new FinalesService();
			ArrayList<Final> finales = fs.getFinalesByUsuario(usuario);
			request.setAttribute("finales", finales);
			getServletContext().getRequestDispatcher("/jsp/Finales.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private boolean validarUsuario(Usuario usuario){
		
		Connection con = Conexion.getConnection();
		
		boolean resultado = false;
		
		String queryStr = "SELECT NOMBRE " 
		          + "FROM USUARIO U "  
		          + "WHERE"
		          + "	U.USUARIO = ? "
		          + "	AND U.PASSWORD = ? "
		          +	"	AND U.PERFIL = ? ";
		
		try{
			PreparedStatement ps = con.prepareStatement(queryStr);
			ps.setString(1, usuario.getUsr());
			ps.setString(2, usuario.getPwd());
			ps.setString(3, usuario.getPerfil());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				resultado = true;
				usuario.setNombre(rs.getString("NOMBRE"));
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
