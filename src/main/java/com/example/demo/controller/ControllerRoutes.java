package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.objects.Materia;
import com.example.demo.service.FirebaseService;




@Controller
public class ControllerRoutes {
	
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

	@RequestMapping("/materias")
	public String vistaMaterias(Model model) {
		String vista="materias";
	
		return vista;
	}

	@RequestMapping("/carreras")
	public String vistaCarreras(Model model) {
		String vista="carreras";
	
		return vista;
	}	
	

	
	
	

}
