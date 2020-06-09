package com.example.demo.objects;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	
	private String idCarrera;
	private String codigoMateria;
	private String nombre;
	
	public Materia() {
		super();
	}

	public Materia(String idCarrera, String codigoMateria, String nombre) {
		super();
		this.idCarrera = idCarrera;
		this.codigoMateria = codigoMateria;
		this.nombre = nombre;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
