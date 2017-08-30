package ar.com.unpaz.poo.observer;

import java.util.Observable;
import java.util.Observer;

public class ProductoObserver implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		

		if (arg1 instanceof CambioPrecio) {
				CambioPrecio cambioPrecio =  (CambioPrecio) arg1;
				System.out.println(arg0 + " Producto: " + cambioPrecio.getProducto() + " Precio Viejo: " + cambioPrecio.getPrecioViejo().toString() + " Precio Nuevo: " + cambioPrecio.getPrecioNuevo().toString());
		}
	}

}
