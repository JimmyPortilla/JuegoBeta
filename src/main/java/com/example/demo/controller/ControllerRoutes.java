package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.objects.Materia;
import com.example.demo.service.FirebaseService;




@Controller
public class ControllerRoutes {
	@Autowired
	
	FirebaseService fireBaseService;
	
	@RequestMapping("/")
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
	
	
///////////////CRUD MATERIAS RUTAS
	
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
	
	

}
