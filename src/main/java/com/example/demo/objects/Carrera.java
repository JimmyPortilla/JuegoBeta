package com.example.demo.objects;
import org.springframework.stereotype.Component;

@Component
public class Carrera {
	
	private String idArea;
	private String codigoCarrera;
	private String nombre;
	
	public Carrera() {
		super();
	}

	public Carrera(String idArea, String codigoCarrera, String nombre) {
		super();
		this.idArea = idArea;
		this.codigoCarrera = codigoCarrera;
		this.nombre = nombre;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getCodigoCarrera() {
		return codigoCarrera;
	}

	public void setCodigoCarrera(String codigoCarrera) {
		this.codigoCarrera = codigoCarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
