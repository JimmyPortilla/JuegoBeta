package com.example.demo.objects;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String idCarrera;
	private String nombre;
	private String apellido;
	private String correo;
	private String password;
	
	public Person() {
		super();
	}

	public Person(String idCarrera, String nombre, String apellido, String correo, String password) {
		super();
		this.idCarrera = idCarrera;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}