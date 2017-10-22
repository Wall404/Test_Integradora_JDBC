package ar.com.unpaz.app.modelo;

public class Final {
	private int id;
	private int id_alumno;
	private int id_materia;
	private String descripcion_materia;
	private float nota;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public String getDescripcion_materia() {
		return descripcion_materia;
	}
	public void setDescripcion_materia(String descripcion_materia) {
		this.descripcion_materia = descripcion_materia;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
}
