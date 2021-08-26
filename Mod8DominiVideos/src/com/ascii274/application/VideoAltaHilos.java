package com.ascii274.application;

import com.ascii274.controller.UsuariController;
import com.ascii274.domain.Usuari;

//public class VideoAltaHilos implements Runnable{
public class VideoAltaHilos extends Thread{

	private UsuariController usuariController;
	
	public VideoAltaHilos(Usuari usuari,UsuariController usuariController) throws Exception {
		this.usuariController = new UsuariController(usuari);
	}
	
	
	public void run() {
		try {
			System.out.println("\nCargando Usuario y datos de videos....");
			Thread.sleep(600);
			System.out.println();
			usuariController.mostrarDadesUsuari();
			usuariController.mostrarTotsElsVideos();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}