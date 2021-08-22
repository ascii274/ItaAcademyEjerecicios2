package com.ascii274.domain;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Usuari {
	private String nom;
	private String cognom;
	private String password;
	private LocalDateTime registre;
	private List<Video> videos;
	

	public Usuari() {
		
	}
	
	public Usuari(String nom, String cognom, String password,LocalDateTime registre) {
		this.nom = nom;
		this.cognom = cognom;
		this.password = password;
		this.registre = registre;
		videos = new ArrayList<>();		
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;		
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	public String getCognom() {
		return cognom;
	}
	
	public void addVideo(Video video) throws Exception{
		if(video == null) throw new Exception("Video vacío");
		videos.add(video);		
	}
	
	public List<Video> getVideos(){
		return new ArrayList<>(videos);		
	}
	
	public String getPassWord() {
		return password;
	}
	
}
