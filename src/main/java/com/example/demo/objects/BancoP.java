package com.example.demo.objects;

import java.util.List;

public class BancoP {
	
	private String codigo;
	private String idArea;
	private String idCarrera;
	private String idMateria;
	private String bimestre;
	private String semana;
	private List<String> preguntas;
	private List<String> respuestas;
	private List<String> resCorrecta;
	
	public BancoP() {
		super();
	}

	public BancoP(String codigo, String idArea, String idCarrera, String idMateria, String bimestre, String semana,
			List<String> preguntas, List<String> respuestas, List<String> resCorrecta) {
		super();
		this.codigo = codigo;
		this.idArea = idArea;
		this.idCarrera = idCarrera;
		this.idMateria = idMateria;
		this.bimestre = bimestre;
		this.semana = semana;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
		this.resCorrecta = resCorrecta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(String idCarrera) {
		this.idCarrera = idCarrera;
	}

	public String getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public List<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}

	public List<String> getResCorrecta() {
		return resCorrecta;
	}

	public void setResCorrecta(List<String> resCorrecta) {
		this.resCorrecta = resCorrecta;
	}
	

	
}
