package ar.com.dbgrid.modelo;

import java.math.BigDecimal;

public class Alumno {

	private int id;
	private String nombre;
	private BigDecimal porcentaCarrera;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPorcentaCarrera() {
		return porcentaCarrera;
	}
	public void setPorcentaCarrera(BigDecimal porcentaCarrera) {
		this.porcentaCarrera = porcentaCarrera;
	} 
	
}
