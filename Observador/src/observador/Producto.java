package observador;

import java.util.Observable;

public class Producto 
{
	private static ProductoObservable OBSERVADOR = new ProductoObservable();
	private String nombre;
	
//	public Producto()
//	{
//	}
	
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
		OBSERVADOR.setChanged();
		OBSERVADOR.notifyObservers("Se genero una instancia de Producto " + nombre);
	}

	public static Observable getOVSERVADOR()
	{
		return OBSERVADOR;
	}
	
}
