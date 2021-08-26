package com.ascii274.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.ascii274.domain.Tag;
import com.ascii274.domain.Usuari;
import com.ascii274.domain.Video;
import com.ascii274.domain.VideoEstatEnum;
import com.ascii274.view.TagView;
import com.ascii274.view.UsuariView;
import com.ascii274.view.VideoView;


public class UsuariController{
	
	private Usuari usuari;
	private Video video;
	private VideoEstatEnum videoEstatEnum;
	
	public UsuariController(Usuari usuari) throws Exception{
		if(usuari == null) throw new Exception("Usuari es null");
		this.usuari = usuari;
	}
	
	// escoger cual es la mejor opcion.
	public void altaVideo(String url, String titol,LocalDateTime dataPujada, int duracio) throws Exception {
		try {
			video = new Video(url, titol,dataPujada, duracio);
			usuari.addVideo(video);
			//videoController.altaTag(titol);
		} catch (Exception e) {
			System.out.println("Error en altaVideo");
		}
	}
	
	public void altaVideo(Video video)throws Exception{
		//video = new Video();
		if(video == null) throw new Exception("Error en altaVideo");
		this.video = new Video(video.getUrl(),video.getTitol(),video.getDataPujada(),video.getDuracio());
		usuari.addVideo(video);
	}
	
	// mostra dades per pantalla
	
	public void mostrarDadesUsuari() throws Exception {
		try {
			UsuariView usuariView = new UsuariView();
			usuariView.printUsuariView(usuari);			
		} catch (Exception e) {
			System.out.println("Error al mostrar dades Usuari");
		}		
	}	
	
	public void mostrarTotsElsVideos() {
		List<Video> videos = usuari.getVideos();
		VideoView videoView = new VideoView();
		TagView tagView = new TagView();
		for(Video v : videos) {
			//muestra datos enum segun la diferencia de minutos.
			videoEstatEnum= mostraEstatVideo(diferenciaMinutos(v.getDataPujada()));
			videoView.printVideoView(v, videoEstatEnum);					
			for(Tag t : v.getTags()) {
				tagView.printTagsView(t);
			}
		}
	}
	
	
	// método que devuelve la diferencia de minutos entre la fecha que hay en la BBDD dataPujada
	public long diferenciaMinutos(LocalDateTime dataPujada) {		
		LocalDateTime dataPujadaEnBBDD;
		LocalDateTime dataActual;
		long dataDiferencia;
		dataPujadaEnBBDD = dataPujada;
		dataActual = LocalDateTime.now();
		dataDiferencia = ChronoUnit.MINUTES.between(dataPujadaEnBBDD, dataActual);			
		return dataDiferencia;
	}
	
	//método que devuelve el estado según la cantidad de minutos que recibe por parametro
	public VideoEstatEnum mostraEstatVideo(long fechaDiferenciaMinutos) {
		
		if(fechaDiferenciaMinutos <1) {
			videoEstatEnum = videoEstatEnum.UPLOADING;
		}
		if(fechaDiferenciaMinutos >1 && fechaDiferenciaMinutos < 3) {
			videoEstatEnum = videoEstatEnum.VERIFYING;
		}
		if(fechaDiferenciaMinutos > 3) {
			videoEstatEnum = videoEstatEnum.PUBLIC;
		}		
		return videoEstatEnum;
	}
	
	public Video getVideo() {
		return video;
	}
	
	

}
