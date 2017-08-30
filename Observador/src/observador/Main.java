package observador;

public class Main
{

	public static void main(String[] args)
	{
		ProductoObservador po = new ProductoObservador();
		
		Producto.getOVSERVADOR().addObserver(po);
		
		Producto p1 = new Producto();
//		p1.addObserver(po);
		p1.setNombre("Producto 1");
		
		Producto p2 = new Producto();
//		p2.addObserver(po);
		p2.setNombre("Producto 2");
		
		Producto p3 =new Producto();
		p3.setNombre("hola");

	}

}
