package ar.com.unpaz.poo.observer;

import java.math.BigDecimal;

public class CambioPrecio {
	
	private BigDecimal precioViejo;
	private BigDecimal precioNuevo;
	private String producto;
	
	
	public CambioPrecio(String producto, BigDecimal precioViejo, BigDecimal precioNuevo ){
		this.producto = producto;
		this.precioViejo = precioViejo;
		this.precioNuevo = precioNuevo;
	}
	
	public BigDecimal getPrecioViejo() {
		return precioViejo;
	}
	public void setPrecioViejo(BigDecimal precioViejo) {
		this.precioViejo = precioViejo;
	}
	public BigDecimal getPrecioNuevo() {
		return precioNuevo;
	}
	public void setPrecioNuevo(BigDecimal precioNuevo) {
		this.precioNuevo = precioNuevo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}

}
