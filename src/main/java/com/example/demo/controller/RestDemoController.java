package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.objects.Area;
import com.example.demo.objects.Carrera;
import com.example.demo.objects.BancoP;
import com.example.demo.objects.Materia;
import com.example.demo.objects.Person;
import com.example.demo.service.FirebaseService;


@CrossOrigin("*")
@RestController
public class RestDemoController {
	
	@Autowired
	FirebaseService fireBaseService;
	
	
	//CRUD USUAIO O PERSON
	@PostMapping("/createUser")
	public String postExample(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return fireBaseService.saveUser(person);
	}
	
	@GetMapping("/getPerson")
	public List<Person>getExample() throws InterruptedException, ExecutionException {
		return fireBaseService.getPerson();
	}
	
	@PutMapping("/updateUser")
	public String putExample(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return fireBaseService.updateUserDetails(person);
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteExample(@RequestHeader String id) {
		return fireBaseService.deleteUser(id);
	}
	
	
	/////CRUD AREA
	@GetMapping("/getArea")
	public List<Area>getArea() throws InterruptedException, ExecutionException {
		return fireBaseService.getArea();
	}
	
	@PostMapping("/createArea")
	public String postArea(@RequestBody Area area) throws InterruptedException, ExecutionException {
		return fireBaseService.saveArea(area);
	}
	
	@PutMapping("/updateArea")
	public String putArea(@RequestBody Area area) throws InterruptedException, ExecutionException {
		return fireBaseService.updateArea(area);
	}
	
	@DeleteMapping("/deleteArea")
	public String deleteArea(@RequestHeader String id) {
		return fireBaseService.deleteArea(id);
	}
	
/////CRUD CARRERA
	@GetMapping("/getCarrera")
	public List<Carrera>getCarrera() throws InterruptedException, ExecutionException {
		return fireBaseService.getCarrera();
	}
	
	@PostMapping("/createCarrera")
	public String postCarrera(@RequestBody Carrera carrera) throws InterruptedException, ExecutionException {
		return fireBaseService.saveCarrera(carrera);
	}
	
	@PutMapping("/updateCarrera")
	public String putCarrera(@RequestBody Carrera carrera) throws InterruptedException, ExecutionException {
		return fireBaseService.updateCarrera(carrera);
	}
	
	@DeleteMapping("/deleteCarrera")
	public String deleteCarrera(@RequestHeader String id) {
		return fireBaseService.deleteCarrera(id);
	}
/////CRUD MATERIA
	@GetMapping("/getMateria")
	public List<Materia>getMateria() throws InterruptedException, ExecutionException {
		return fireBaseService.getMateria();
	}
	
	@PostMapping("/createMateria")
	public String postMateria(@RequestBody Materia materia) throws InterruptedException, ExecutionException {
		return fireBaseService.saveMateria(materia);
	}
	@PostMapping("/createMateria1")
	public void postMateria1(@RequestParam(name="idCarrera") String idCarrera, 
			@RequestParam(name="codigoMateria") String codigoMateria,
			@RequestParam(name="nombre") String nombre) throws InterruptedException, ExecutionException {
		Materia objMateria = new Materia(idCarrera, codigoMateria, nombre);
		fireBaseService.saveMateria(objMateria);
	}
	
	@PutMapping("/updateMateria")
	public String putMateria(@RequestBody Materia materia) throws InterruptedException, ExecutionException {
		return fireBaseService.updateMateria(materia);
	}
	
	@DeleteMapping("/deleteMateria")
	public String deleteMateria(@RequestHeader String id) {
		return fireBaseService.deleteMateria(id);
	}
/////CRUD CUESTIONARIO
	@PostMapping("/createPreguntas")
	public String postCuestionario(@RequestBody BancoP bancop) throws InterruptedException, ExecutionException {
		return fireBaseService.savePreguntas(bancop);
	}
	@GetMapping("/getPreguntas")
	public List<BancoP>getPreguntas() throws InterruptedException, ExecutionException {
		return fireBaseService.getPreguntas();
	}
	
	
	
	
}
