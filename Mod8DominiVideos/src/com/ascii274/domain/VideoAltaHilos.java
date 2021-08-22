package com.ascii274.domain;



import com.ascii274.controller.UsuariController;

public class VideoAltaHilos implements Runnable{
	private UsuariController usuariController;
	
	public VideoAltaHilos(Usuari usuari,UsuariController usuariController) throws Exception {
		this.usuariController = new UsuariController(usuari);
	}
	
	public void run() {
		try {
			System.out.println("Cargando videos....");
			Thread.sleep(600);
			System.out.println();
			usuariController.mostrarDadesUsuari();
			usuariController.mostrarTotsElsVideos();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}