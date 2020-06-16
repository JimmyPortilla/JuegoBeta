package com.example.demo.objects;

public class Docente {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String clave;
	private String correoUTPL;
	
	public Docente() {
		super();
	}

	public Docente(String cedula, String nombre, String apellido, String clave, String correoUTPL) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
		this.correoUTPL = correoUTPL;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreoUTPL() {
		return correoUTPL;
	}

	public void setCorreoUTPL(String correoUTPL) {
		this.correoUTPL = correoUTPL;
	}
	
	
	

}
