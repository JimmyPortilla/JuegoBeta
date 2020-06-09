package com.example.demo.objects;

import org.springframework.stereotype.Component;

@Component
public class Area {
	
	private String codigo;
	private String nombre;
	
	public Area() {
		super();
	}

	public Area(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
