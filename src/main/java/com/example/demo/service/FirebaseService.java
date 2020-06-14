package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.objects.Area;
import com.example.demo.objects.Carrera;
import com.example.demo.objects.BancoP;
import com.example.demo.objects.Materia;
import com.example.demo.objects.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


@Service
public class FirebaseService {
	
/////SERVICE PERSON
	
	public String saveUser(Person person) throws InterruptedException, ExecutionException {	
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("persons").document(person.getCedula()).set(person);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	
	public List<Person> getPerson() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ArrayList<Person> returnArray = new ArrayList();
		ApiFuture<QuerySnapshot> future = dbFirestore.collection("persons").get();
		// future.get() blocks on response
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents) {
			returnArray.add(document.toObject(Person.class));
			//System.out.println(document.getId() + " => " + document.toObject(Usuario.class));
		}
		return returnArray;
	}
	
	public String updateUserDetails(Person person) throws InterruptedException, ExecutionException  {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("persons").document().set(person);
		return collectionsApiFuture.get().getUpdateTime().toString();
	}
	
	 
	   
	   public String deleteUser(String id) {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> writeResult = dbFirestore.collection("persons").document(id).delete();
			return "El usuario"+id+" a sido eliminado";
		}
	
/////SERVICE AREA
	   
	   public String saveArea(Area area) throws InterruptedException, ExecutionException {	
			Firestore dbFirestore = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("area").document(area.getCodigo()).set(area);
			return collectionsApiFuture.get().getUpdateTime().toString();
		}
	   
	   public List<Area> getArea() throws InterruptedException, ExecutionException {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			ArrayList<Area> returnArray = new ArrayList();
			ApiFuture<QuerySnapshot> future = dbFirestore.collection("area").get();
			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
			for (DocumentSnapshot document : documents) {
				returnArray.add(document.toObject(Area.class));
				
			}
			return returnArray;
		}
	   
	   public String updateArea(Area area) throws InterruptedException, ExecutionException  {
			Firestore dbFirestore = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("area").document().set(area);
			return collectionsApiFuture.get().getUpdateTime().toString();
		}
		   
		   public String deleteArea(String id) {
				Firestore dbFirestore = FirestoreClient.getFirestore();
				ApiFuture<WriteResult> writeResult = dbFirestore.collection("area").document(id).delete();
				return "El area " + id +" a sido eliminada";
			}
		
///////SERVICE CARRERA
		   
		   public String saveCarrera(Carrera carrera) throws InterruptedException, ExecutionException {	
				Firestore dbFirestore = FirestoreClient.getFirestore();
				ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("carrera").document(carrera.getCodigoCarrera()).set(carrera);
				return collectionsApiFuture.get().getUpdateTime().toString();
			}
		   
		   public List<Carrera> getCarrera() throws InterruptedException, ExecutionException {
				Firestore dbFirestore = FirestoreClient.getFirestore();
				ArrayList<Carrera> returnArray = new ArrayList();
				ApiFuture<QuerySnapshot> future = dbFirestore.collection("carrera").get();
				List<QueryDocumentSnapshot> documents = future.get().getDocuments();
				for (DocumentSnapshot document : documents) {
					returnArray.add(document.toObject(Carrera.class));
					
				}
				return returnArray;
			}
		   
		   public String updateCarrera(Carrera carrera) throws InterruptedException, ExecutionException  {
				Firestore dbFirestore = FirestoreClient.getFirestore();
				ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("carrera").document().set(carrera);
				return collectionsApiFuture.get().getUpdateTime().toString();
			}
			   
			   public String deleteCarrera(String id) {
					Firestore dbFirestore = FirestoreClient.getFirestore();
					ApiFuture<WriteResult> writeResult = dbFirestore.collection("carrera").document(id).delete();
					return "La carrera " + id +" a sido eliminada";
				}
			   
			   
///////SERVICE MATERIAS
			   
			   public String saveMateria(Materia materia) throws InterruptedException, ExecutionException {	
					Firestore dbFirestore = FirestoreClient.getFirestore();
					ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("materia").document(materia.getCodigoMateria()).set(materia);
					return collectionsApiFuture.get().getUpdateTime().toString();
				}
			   
			   public List<Materia> getMateria() throws InterruptedException, ExecutionException {
					Firestore dbFirestore = FirestoreClient.getFirestore();
					ArrayList<Materia> returnArray = new ArrayList();
					ApiFuture<QuerySnapshot> future = dbFirestore.collection("materia").get();
					List<QueryDocumentSnapshot> documents = future.get().getDocuments();
					for (DocumentSnapshot document : documents) {
						returnArray.add(document.toObject(Materia.class));
						
					}
					return returnArray;
				}
			   
			   public String updateMateria(Materia materia) throws InterruptedException, ExecutionException  {
					Firestore dbFirestore = FirestoreClient.getFirestore();
					ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("materia").document().set(materia);
					return collectionsApiFuture.get().getUpdateTime().toString();
				}
				   
				   public String deleteMateria(String id) {
						Firestore dbFirestore = FirestoreClient.getFirestore();
						ApiFuture<WriteResult> writeResult = dbFirestore.collection("materia").document(id).delete();
						return "La materia  " + id +" a sido eliminada";
					}
				   
				   
///////SERVICE PREGUNTAS
				   
				public String savePreguntas(BancoP bancop) throws InterruptedException, ExecutionException {	
						Firestore dbFirestore = FirestoreClient.getFirestore();
						ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("bancoP").document().set(bancop);
						//return collectionsApiFuture.get().getUpdateTime().toString();
						return "Pregunta ingresada ";
					}				   
				 public List<BancoP> getPreguntas() throws InterruptedException, ExecutionException {
						Firestore dbFirestore = FirestoreClient.getFirestore();
						ArrayList<BancoP> returnArray = new ArrayList();
						ApiFuture<QuerySnapshot> future = dbFirestore.collection("bancoP").get();
						List<QueryDocumentSnapshot> documents = future.get().getDocuments();
						for (DocumentSnapshot document : documents) {
							returnArray.add(document.toObject(BancoP.class));
							
						}
						return returnArray;
					}
				 
				  public String updatePreguntas(BancoP bancoP) throws InterruptedException, ExecutionException  {
						Firestore dbFirestore = FirestoreClient.getFirestore();
						ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("bancoP").document().set(bancoP);
						return collectionsApiFuture.get().getUpdateTime().toString();
					}
					   
					   public String deletePreguntas(String id) {
							Firestore dbFirestore = FirestoreClient.getFirestore();
							ApiFuture<WriteResult> writeResult = dbFirestore.collection("bancoP").document(id).delete();
							return "La pregunta  " + id +" a sido eliminada";
						}
	
}