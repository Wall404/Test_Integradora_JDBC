package ar.com.unpaz.poo.observer;

import java.math.BigDecimal;

public class Producto {
	 private BigDecimal precio;
	 private String producto;
	

	 private final static ObservableProducto OBSERVER= new ObservableProducto();
	 
	 public Producto(String producto, BigDecimal precio){
		 this.producto = producto;
		 this.precio = precio;
	 }

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		
		CambioPrecio cambioPrecio = new CambioPrecio(this.producto, this.precio, precio);
		this.precio = precio;
		OBSERVER.setChanged();
		OBSERVER.notifyObservers(cambioPrecio);
		
	}


	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public static ObservableProducto getObserver() {
		return OBSERVER;
	}

}
