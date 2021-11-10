package com.ascii274.practicas.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="partides")
public class Partida {
	@Id		
	private int id;
	@Field(name="dau1")
	private int dau1;
	@Field(name="dau2")
	private int dau2;
	@Field(name="resultat")
	private boolean resultat; // 0:false 1:true ( guanya = 7 )
	@Field(name="id_usuari")
	private int idUsuari;
	
	public Partida() {	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDau1() {
		return dau1;
	}

	public void setDau1(int dau1) {
		this.dau1 = dau1;
	}

	public int getDau2() {
		return dau2;
	}

	public void setDau2(int dau2) {
		this.dau2 = dau2;
	}


	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public int getIdUsuari() {
		return idUsuari;
	}

	public void setIdUsuari(int idUsuari) {
		this.idUsuari = idUsuari;
	}	
	
	
	

}
