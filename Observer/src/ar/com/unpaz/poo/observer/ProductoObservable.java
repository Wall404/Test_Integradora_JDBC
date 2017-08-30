package ar.com.unpaz.poo.observer;

import java.math.BigDecimal;
import java.util.Observable;

public class ProductoObservable extends Observable {
	
	 private BigDecimal precio;
	 private String producto;
	

	 
	 public ProductoObservable(String producto, BigDecimal precio){
		 this.producto = producto;
		 this.precio = precio;
	 }

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		
		CambioPrecio cambioPrecio = new CambioPrecio(this.producto, this.precio, precio);
		this.precio = precio;
		setChanged();
		notifyObservers(cambioPrecio);
		
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}





}
