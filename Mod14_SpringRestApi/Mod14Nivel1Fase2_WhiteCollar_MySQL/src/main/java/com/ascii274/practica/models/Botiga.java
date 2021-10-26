package com.ascii274.practica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="botigues")

public class Botiga {
	@Id	
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom",nullable = true, length = 50)
	private String nom;
	
	private int capacitatProductes;
	
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
	
	public int getCapacitatProductes() {
		return capacitatProductes;
	}
	public void setCapacitatProductes(int capacitatProductes) {
		this.capacitatProductes = capacitatProductes;
	}

	

}