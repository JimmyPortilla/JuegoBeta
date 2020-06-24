package com.example.demo.objects;

public class BancoP {
	
	
	private String idArea;
	private String idCarrera;
	private String idMateria;
	private String docente;
	private String pregunta;
	private String res1;
	private String res2;
	private String res3;
	private String resCorrecta;
	
	public BancoP() {
		super();
	}

	public BancoP(String idArea, String idCarrera, String idMateria, String docente, String pregunta, String res1,
			String res2, String res3, String resCorrecta) {
		super();
		this.idArea = idArea;
		this.idCarrera = idCarrera;
		this.idMateria = idMateria;
		this.docente = docente;
		this.pregunta = pregunta;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.resCorrecta = resCorrecta;
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

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public String getRes2() {
		return res2;
	}

	public void setRes2(String res2) {
		this.res2 = res2;
	}

	public String getRes3() {
		return res3;
	}

	public void setRes3(String res3) {
		this.res3 = res3;
	}

	public String getResCorrecta() {
		return resCorrecta;
	}

	public void setResCorrecta(String resCorrecta) {
		this.resCorrecta = resCorrecta;
	}
	
}
