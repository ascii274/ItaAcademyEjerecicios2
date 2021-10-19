package com.ascii274.practica.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




public class Empleat {
	private static int idSiguiente=1;
	private int id=0; 	
	private String nom;
	private String faena;
	
	
	/**
	 * - Uses on Nivel1
	 * @param nom
	 * @param faena
	 */
	public Empleat() {
		
	}
	public Empleat(String nom, String faena) {
		id = idSiguiente;
		this.nom = nom;
		this.faena = faena;
		idSiguiente++;
	}
	
	public Empleat(int id, String nom, String faena) {
		this.id = id;
		this.nom = nom;
		this.faena = faena;
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

	public String getFaena() {
		return faena;
	}

	public void setFaena(String faena) {
		this.faena = faena;
	}

	
	

}
