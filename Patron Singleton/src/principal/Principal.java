package principal;

import singleton.ClaseLogSingleton;
import ventanas.VentanaPrincipal;
import vo.PersonaVo;

/**
 * @author HENAO
 *
 */
public class Principal {

	/**
	 * Obtiene un arreglo de personas y las envia a la ventana
	 * principal
	 * @param args
	 */
	public static void main(String[] args) {
		 Principal miPrincipal = new Principal();
		 PersonaVo[] personas=miPrincipal.crearPersonas();
		 VentanaPrincipal miVentanaPrincipal=new VentanaPrincipal(personas);
		 miVentanaPrincipal.setVisible(true);
	}

	/**
	 * Permite crear las 3 personas del ejemplo y almacenarlas en un arreglo
	 * de personas
	 * @return
	 */
	private PersonaVo[] crearPersonas() {
		PersonaVo persona1= new PersonaVo();
		persona1.setNombre("Pedro");
		persona1.setDocumento(1);
		
		PersonaVo persona2= new PersonaVo();
		persona2.setNombre("Pablo");
		persona2.setDocumento(2);
		
		PersonaVo persona3= new PersonaVo();
		persona3.setNombre("Paco");
		persona3.setDocumento(3);
				
		PersonaVo personas[] = {persona1,persona2,persona3};
		
		return personas;
	}
}
