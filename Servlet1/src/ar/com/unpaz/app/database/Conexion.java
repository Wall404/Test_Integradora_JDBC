package ar.com.unpaz.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

	
	private  final static String DB_DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private  static String DB_URL = "jdbc:sqlserver://localhost:1433;instance=MSSQLSERVER14;databaseName=CARRERA";
	private  static String DB_USERNAME = "carrera";
	private  static String DB_PASSWORD = "carrera1";
	
	static {

        try {      	
        	Class.forName(DB_DRIVER_CLASS);      	
        }

		catch(ClassNotFoundException error)
		{
			System.out.println("Error: al cargar el driver de conexión a la Base " + error);
			
		}
	}
	
	
	public static Connection getConnection() 
	{

        Connection con = null;
        try {
  	
            con = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
			return(con);
		}


		catch(SQLException error)
		{
			System.out.println(DB_DRIVER_CLASS + " Error: en el socket de conexión a la base " + error);
			return(null);
		}
	
	}
}
