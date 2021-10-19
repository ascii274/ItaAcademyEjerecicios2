package com.ascii274.practica.bean;

public class Empleat {
	private int id=0; 
	private static int idSiguiente=1;
	private String nom;
	private EnumFeina faena;
	
	public Empleat(String nom, EnumFeina faena) {
//		super();
		id = idSiguiente;
		this.nom = nom;
		this.faena = faena;
		idSiguiente++;
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

	public EnumFeina getFaena() {
		return faena;
	}

	public void setFaena(EnumFeina faena) {
		this.faena = faena;
	}

	
	

}
