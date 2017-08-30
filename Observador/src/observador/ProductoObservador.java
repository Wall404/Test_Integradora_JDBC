package observador;

import java.util.Observable;
import java.util.Observer;

public class ProductoObservador implements Observer
{
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		System.out.println("se notifico " + arg1);

	}

}
