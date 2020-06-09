package com.example.demo.objects;

import java.util.List;

public class BancoP {
	
	
	private String idMateria;
	private String titloBanco;

	private List<String> lsPreguntas;
	private List<Boolean> lsRespuestas;
	
	public BancoP() {
		super();
	}

	public BancoP(String idMateria, String titloBanco, List<String> lsPreguntas, List<Boolean> lsRespuestas) {
		super();
		this.idMateria = idMateria;
		this.titloBanco = titloBanco;
		this.lsPreguntas = lsPreguntas;
		this.lsRespuestas = lsRespuestas;
	}

	public String getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(String idMateria) {
		this.idMateria = idMateria;
	}

	public String getTitloBanco() {
		return titloBanco;
	}

	public void setTitloBanco(String titloBanco) {
		this.titloBanco = titloBanco;
	}

	public List<String> getLsPreguntas() {
		return lsPreguntas;
	}

	public void setLsPreguntas(List<String> lsPreguntas) {
		this.lsPreguntas = lsPreguntas;
	}

	public List<Boolean> getLsRespuestas() {
		return lsRespuestas;
	}

	public void setLsRespuestas(List<Boolean> lsRespuestas) {
		this.lsRespuestas = lsRespuestas;
	}
	
}
