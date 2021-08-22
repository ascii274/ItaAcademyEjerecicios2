package com.ascii274.application;

import java.time.LocalDateTime;
import com.ascii274.controller.UsuariController;
import com.ascii274.controller.VideoController;
import com.ascii274.domain.Usuari;
import com.ascii274.domain.Video;
import com.ascii274.domain.VideoAltaHilos;


/**
 * @author joel
 * Patrón aplicado: MVC
 * 
 * Nivell 1 ok.
 * Nivell 2 ok.
 *
 */
public class VideoMain {	
	//static para no crear tantas instancias la variable.
	static private VideoController videoController; 
	static private Video video;
	
	public static void main(String[] args) {
		CampsBuits campsBuits = new CampsBuits();
		//VideoEstat videoEstat;

		try {
			//LocalDateTime fechaRegistro = LocalDateTime.now();
			//creamos usuario 
			Usuari usuari = new Usuari("Joel", "Cabatay","pwd1234",LocalDateTime.now());			
			UsuariController usuariController = new UsuariController(usuari);
			campsBuits.comprovarCampsBuitsUsuari(usuari);// comprobamos campos vacíos
			
			//****** creación de un video 1 con fecha antiguo *****
			video = new Video("http://www.miPrimerVideo.com","Programando Java",LocalDateTime.of(2021,8,21,20,20));	
			usuariController.altaVideo(video);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());			
			videoController = new VideoController(video); 
			videoController.altaTag("Programación");
			videoController.altaTag("Java");
			
			
			//****** creación del video 2 con fecha actual *****
			video = new Video("http://www.miSegundoVideo.com","Editar Imágenes con Gimp",LocalDateTime.now());
			usuariController.altaVideo (video);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());
			videoController = new VideoController(video);
			videoController.altaTag("Instalación Gimp");
			videoController.altaTag("Configuración Gimp");
			
			//****** creación del video 3 con fecha actual *****
			// modificar fecha para que la diferencia ses entre 1 y 3 minutos con la hora actual
			
			video = new Video("http://www.TercerVideo.com","Instalación linux",LocalDateTime.of(2021,8,22,11,32));
			usuariController.altaVideo (video);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());			
			videoController = new VideoController(video); 
			videoController.altaTag("Linux");
			videoController.altaTag("InstalaciónLinux");
			
			//******* thread *********
			Runnable runnable = new VideoAltaHilos(usuari, usuariController);
			Thread thread = new Thread(runnable);
			thread.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				
	}
	

}
