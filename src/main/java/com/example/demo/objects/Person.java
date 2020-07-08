package com.example.demo.objects;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String idCarrera;
	private String cedula;
	private String nombre;
	private String apellido;
	
	public Person() {
		super();
	}

	public Person(String idCarrera, String cedula, String nombre, String apellido) {
		super();
		this.idCarrera = idCarrera;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
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
	
	
	
	
	
	
	
}