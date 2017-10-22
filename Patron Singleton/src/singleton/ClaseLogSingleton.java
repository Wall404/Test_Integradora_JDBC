package singleton;

public class ClaseLogSingleton {

	private String contenido;

	/** objeto Singleton */
	private static ClaseLogSingleton miLogSingleton;

	private ClaseLogSingleton() {
		setContenido("Eventos de Usuario\n\n");
	}

	/**
	 * @return the miArchivoSingleton
	 */
	public static ClaseLogSingleton getMiLogSingleton() {
		if (miLogSingleton == null)
			miLogSingleton = new ClaseLogSingleton();
		
		return miLogSingleton;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido
	 *            the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
