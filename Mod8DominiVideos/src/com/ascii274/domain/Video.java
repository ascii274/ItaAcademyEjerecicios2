package com.ascii274.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Video {
	private String url;
	private String titol;
	//private String estatPujada;
	private LocalDateTime dataPujada;
	private List<Tag> tags; 
	
	public Video() {
		
	}
	public Video(String url,String titol,LocalDateTime dataPujada) {
		this.url = url;
		this.titol = titol;
		//estatPujada = "Null";
		this.dataPujada = dataPujada;
		tags =new ArrayList<>();
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void addTag(Tag tag) throws Exception{
		if(tag == null)throw new Exception("Metodo AddTag.Valor tag is null");
		tags.add(tag);		
	}
	
	public List<Tag> getTags() {
		return new ArrayList<>(tags);
	}
	
	public LocalDateTime getDataPujada() {
		return dataPujada;
	}
	

}
