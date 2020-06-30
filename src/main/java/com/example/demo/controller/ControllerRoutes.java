package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.objects.BancoP;
import com.example.demo.objects.Docente;
import com.example.demo.objects.Materia;
import com.example.demo.service.FirebaseService;




@Controller
public class ControllerRoutes {
	@Autowired
	
	FirebaseService fireBaseService;
	Docente sesion = null;
	
	@RequestMapping("/")
	public String login(Model model) {
		String vista="login";
	
		return vista;
	}
	
	
	@RequestMapping("/preguntas")
	public String preguntas(Model model) {
		String vista="preguntas";
	
		return vista;
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		String vista="index";
	
		return vista;
	}

	@RequestMapping("/alumnos")
	public String vistaAlumnos(Model model) {
		String vista="alumnos";
	
		return vista;
	}

	

	@RequestMapping("/carreras")
	public String vistaCarreras(Model model) {
		String vista="carreras";
	
		return vista;
	}
	
///////INICIO DE DOCENTE////////////////////////////////////////////////////////////
	@PostMapping("/ingresar")
	public String ingresar(@RequestParam(name="correoUTPL", required=false) String correoUTPL, 
			@RequestParam(name="clave", required=false) String clave,Model model) throws Exception {
		String vista="";
		sesion = fireBaseService.validarLogin(correoUTPL, clave);
		
		if(sesion !=null){
			
			model.addAttribute("sesionActual", sesion);
			vista="index";
		}else {
			model.addAttribute("datos_incorrectos", true );
			vista="login";
		}
		
		return vista;
	 }
	
///////////////CRUD DOCENTE RUTAS///////////////////////////////////////	
	
	@RequestMapping("/docente")
	public String docente(Model model) {
		String vista="docente";
	
		return vista;
	}
	
	@PostMapping("/docente")
	public String postDocente(@RequestParam(name="cedula") String cedula, 
			@RequestParam(name="nombre") String nombre,
			@RequestParam(name="apellido") String apellido,@RequestParam(name="clave") String clave,@RequestParam(name="correoUTPL") String correoUTPL) throws InterruptedException, ExecutionException {
		String vista ="login";
		Docente docente = new Docente(cedula, nombre, apellido,clave,correoUTPL);
		fireBaseService.saveDocente(docente);
		return vista;
	}
	
	@PostMapping("/updateDocente")
	public String updateDocente(@RequestParam(name="cedula") String cedula, 
			@RequestParam(name="nombre") String nombre,
			@RequestParam(name="apellido") String apellido,
			@RequestParam(name="clave") String clave,
			@RequestParam(name="correoUTPL") String correoUTPL) throws InterruptedException, ExecutionException {
		String vista ="docente";
		Docente docente = new Docente(cedula, nombre, apellido, clave,correoUTPL);
		fireBaseService.saveDocente(docente);
		return vista;
	}
	
	@PostMapping("/deleteDocente")
	public String deleteDocente(@RequestParam(name="id", required=false) String id,
    		Model model) throws InterruptedException, ExecutionException {
		String vista= "docente";
		fireBaseService.deleteDocente(id);
		
		return vista;
	}
///////////////CRUD MATERIAS RUTAS/////////////////////////////////////////////////
	
	@RequestMapping("/materias")
	public String vistaMaterias(Model model) {
		String vista="materias";
	
		return vista;
	}
	
	@PostMapping("/materias")
	public String postMateria1(@RequestParam(name="idCarrera") String idCarrera, 
			@RequestParam(name="codigoMateria") String codigoMateria,
			@RequestParam(name="nombre") String nombre) throws InterruptedException, ExecutionException {
		String vista ="materias";
		Materia objMateria = new Materia(idCarrera, codigoMateria, nombre);
		fireBaseService.saveMateria(objMateria);
		return vista;
		
	}
	
	@PostMapping("/updateMateria")
	public String updateMateria(@RequestParam(name="idCarrera") String idCarrera, 
			@RequestParam(name="codigoMateria") String codigoMateria,
			@RequestParam(name="nombre") String nombre)  throws InterruptedException, ExecutionException {
		String vista="materias";
		Materia materia = new Materia(idCarrera, codigoMateria, nombre);
		fireBaseService.saveMateria(materia);
		return vista;
	}
	
	@PostMapping("/deleteMateria")
	public String deleteMateria(@RequestParam(name="id", required=false) String id,
    		Model model) throws InterruptedException, ExecutionException {
		String vista= "materias";
		fireBaseService.deleteMateria(id);
		
		return vista;
	}
	
///////////////CRUD PREGUNTAS RUTAS/////////////////////////////////////////////////
	
	@PostMapping("/createPregunta")
	public String postCuestionario(@RequestParam(name="codigo") String codigo, 
		@RequestParam(name="area") String area,
		@RequestParam(name="carrera") String carrera,
		@RequestParam(name="materia") String materia,
		@RequestParam(name="preguntas") String preguntas,
		@RequestParam(name="respuestas") String respuestas,
		@RequestParam(name="resCorrecta") String resCorrecta) throws InterruptedException, ExecutionException {
		String vista ="index";
		
		
		String[] parts_preguntas = preguntas.split(";");
		List<String> final_preguntas = new ArrayList<String>(Arrays.asList(parts_preguntas));
	
		List<String> parts_respuestas = Arrays.asList(respuestas.split(";"));
		List<String> parts_resCorrecta = Arrays.asList(resCorrecta.split(";"));
		
		
		
		BancoP bancoP = new BancoP(codigo, area, carrera, materia,final_preguntas, parts_respuestas, parts_resCorrecta);
		fireBaseService.savePreguntas(bancoP);
		return vista;
	}
	/*
	@PostMapping("/updatePregunta")
	public String updatePregunta(@RequestParam(name="area") String area, 
			@RequestParam(name="carrera") String carrera,
			@RequestParam(name="materia") String materia,
			@RequestParam(name="pregunta") String pregunta,
			@RequestParam(name="res1") String res1,
			@RequestParam(name="res2") String res2,
			@RequestParam(name="res3") String res3,
			@RequestParam(name="resCorrecta") String resCorrecta) throws InterruptedException, ExecutionException {
	String vista="index";
	BancoP bancoP = new BancoP(area, carrera, materia,docente,pregunta,res1,res2,res3,resCorrecta);
	fireBaseService.savePreguntas(bancoP);
	return vista;
	}*/
	
	@PostMapping("/deletePregunta")
	public String deletePreguntas(@RequestParam(name="id", required=false) String id,
		Model model) throws InterruptedException, ExecutionException {
	String vista= "index";
	fireBaseService.deletePreguntas(id);
	
	return vista;
	}
	
	

}
