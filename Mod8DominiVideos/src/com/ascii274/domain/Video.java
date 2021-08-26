package com.ascii274.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Video {
	private String url;
	private String titol;	
	//private String estatPujada;
	private LocalDateTime dataPujada;
	private int duracio; // en segons
	private List<Tag> tags; 
	
	private int tempsReproduccio;
	
	private static EstatEnum estatusEnum;
	private static int horas=0;
	private static int minutos=0;
	private static int segundos=0;	
	
	public Video() {
		
	}
	public Video(String url,String titol,LocalDateTime dataPujada, int duracio) {		
		this.url = url;
		this.titol = titol;
		this.dataPujada = dataPujada;
		this.duracio = duracio;
		tags =new ArrayList<>();
	}
	
	public void reproducirVideo() {
		int i=0;
		System.out.println("\nTitol: " + titol + " Estado: "+ estatusEnum.REPRODUINT);
		while(i<duracio) {
			
			try {
				mostrarTiempReproduccion();
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
				//System.out.println("La reproducción se ha interrumpido.");
				//i=duracio; // igualamos tiempo para finalizar 
			}
			i++;
		}
	}
			
	
	// contador de segundos para la reproduccion
	public int contadorTemposProduccio() {
		return tempsReproduccio++;
	}
	
	//muestra el tiempo de reproduccion
	public void mostrarTiempReproduccion() {		
		String contadorMensajeReproduccion;
		segundos =contadorTemposProduccio();
		if(segundos == 60) {
			segundos=0;
			minutos ++;
		}
		if(minutos == 60) {
			minutos =0;
			horas++;
		}
		contadorMensajeReproduccion = horas+":"+minutos+":"+segundos;		
		//System.out.println("Reproduciendo: " + Thread.currentThread().getName()+ " "+ contadorMensajeReproduccion);
		System.out.println("Reproduciendo: " + contadorMensajeReproduccion + " duración:" + duracio + " segundos;" + " Titulo:" +titol );

	}
	
	
	// getters setters
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
	
	public int getDuracio() {
		return duracio;
	}
	public static EstatEnum getEstatusEnum() {
		return estatusEnum;
	}
	public static void setEstatusEnum(EstatEnum estatusEnum) {
		Video.estatusEnum = estatusEnum;
	}
	public int getTempsReproduccio() {
		return tempsReproduccio;
	}
	
	
	
}
