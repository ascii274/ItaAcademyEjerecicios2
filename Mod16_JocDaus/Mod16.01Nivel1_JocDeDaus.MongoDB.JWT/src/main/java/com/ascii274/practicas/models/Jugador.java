package com.ascii274.practicas.models;

import javax.persistence.Id;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="jugadors")
public class Jugador {
	@Id
	private int id;
	@Field(name="nom")	
	private String nom;
	@Field(name="fecha")
	private String fecha;
	 
	public Jugador() {	
		 
	}

	public Jugador(int id, String nom, String fecha) {		
		this.id = id;
		this.nom = nom;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	 
	


}
