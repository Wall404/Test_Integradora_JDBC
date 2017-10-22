package ar.com.unpaz.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.unpaz.app.modelo.Alumno;
import ar.com.unpaz.app.modelo.Final;
import ar.com.unpaz.app.servicios.AlumnoService;
import ar.com.unpaz.app.servicios.FinalesService;

/**
 * Servlet implementation class FinalesByAlumno
 */
@WebServlet("/FinalesByAlumno")
public class FinalesByAlumno extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String id_alumno = request.getParameter("id_alumno");
			AlumnoService alumnoService = new AlumnoService();
			Alumno alumno = new Alumno();
			alumno = alumnoService.getAlumno(Integer.parseInt(id_alumno));
			FinalesService finalesService = new FinalesService();
			
			ArrayList<Final> finales = finalesService.getFinalesByAlumno(alumno);
			request.setAttribute("alumno", alumno);
			request.setAttribute("finales", finales);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/Finales.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
