package ar.com.unpaz.poo.observer;

import java.math.BigDecimal;

public class TestObserver {

	public static void main(String[] args) {
		
		ProductoObserver productoObserver = new ProductoObserver();
		
//		ProductoObservable p1 = new ProductoObservable("Cigarros", new BigDecimal("54.30"));
//		p1.addObserver(productoObserver);
//		
//		ProductoObservable p2 = new ProductoObservable("Lata Coca", new BigDecimal("88.15"));
//		p2.addObserver(productoObserver);
//		
//		ProductoObservable p3 = new ProductoObservable("Sin Observer", new BigDecimal("28.05"));
//		
//		p1.setPrecio( new BigDecimal("77.25"));
//		p2.setPrecio( new BigDecimal("99.25"));
//		p3.setPrecio( new BigDecimal("33.00"));
//		
		
		
		Producto.getObserver().addObserver(productoObserver);
		
		Producto p11 = new Producto("Cigarros", new BigDecimal("54.30"));
		
		
		Producto p22 = new Producto("Lata Coca", new BigDecimal("88.15"));
		
		Producto p33 = new Producto("Sin Observer", new BigDecimal("28.05"));
		
		p11.setPrecio( new BigDecimal("77.25"));
		p22.setPrecio( new BigDecimal("99.25"));
		p33.setPrecio( new BigDecimal("33.00"));
		
		
	}

}
