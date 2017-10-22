package ar.com.unpaz.app.modelo;

public class Usuario {
	
	public Usuario (String usr, String pwd, String perfil){
		this.usr = usr;
		this.pwd = pwd;
		this.perfil = perfil;
	}

	private String usr;
	private String pwd;
	private String perfil;
	private String nombre;
	
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
