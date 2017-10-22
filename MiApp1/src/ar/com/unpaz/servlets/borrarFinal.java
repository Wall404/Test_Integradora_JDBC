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
 * Servlet implementation class borrarFinal
 */
@WebServlet("/borrarFinal")
public class borrarFinal extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public borrarFinal()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    Alumno alumno = new Alumno();
	    String ID_ALUMNO = request.getParameter("ID_ALUMNO");
	    String ID_MATERIA = request.getParameter("ID_MATERIA");
	    
	    FinalesService fs = new FinalesService();
	    AlumnoService as = new AlumnoService();
	    
	    alumno = as.getAlumno(Integer.parseInt(ID_ALUMNO));
	    fs.borrarFinal(Integer.parseInt(ID_ALUMNO), Integer.parseInt(ID_MATERIA));
	    
	    ArrayList<Final> finales = fs.getFinalesByAlumno(alumno);
	    request.setAttribute("alumno", alumno);
	    request.setAttribute("finales", finales);
	    getServletContext().getRequestDispatcher("/WEB-INF/jsp/Finales.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
