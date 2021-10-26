package com.ascii274.practica.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quadres")
public class Quadre {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nom", nullable = true,length = 50)
	private String nom;
	
	@Column(name="fecha_entrada")
	private LocalDateTime fechaEntrada;
	
	@Column(name="botiga_id")
	private int botigaId;
	
	
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
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public int getBotigaId() {
		return botigaId;
	}
	public void setBotigaId(int botigaId) {
		this.botigaId = botigaId;
	}

	
	
	
	
	
}

