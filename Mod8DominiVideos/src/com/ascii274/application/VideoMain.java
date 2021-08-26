package com.ascii274.application;

import java.time.LocalDateTime;
import com.ascii274.controller.UsuariController;
import com.ascii274.controller.VideoController;
import com.ascii274.domain.Usuari;
import com.ascii274.domain.Video;

import java.util.Scanner;



/**
 * @author joel
 * Patrón aplicado: MVC
 * 
 * Nivell 1 ok.
 * Nivell 2 ok.
 * Nivell 3 No he conseguido modificar el estado cuando esta pausado.
 *
 */
public class VideoMain {	
	//static para no crear tantas instancias la variable.
	static private VideoController videoController; 
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CampsBuits campsBuits = new CampsBuits();
		//VideoEstat videoEstat;

		try {
			//LocalDateTime fechaRegistro = LocalDateTime.now();
			//creamos usuario 
			Usuari usuari = new Usuari("Joel", "Cabatay","pwd1234",LocalDateTime.now());			
			UsuariController usuariController = new UsuariController(usuari);
			campsBuits.comprovarCampsBuitsUsuari(usuari);// comprobamos campos vacíos
			
			//****** creación de un video 1 con fecha antiguo *****
			Video video1 = new Video("http://www.miPrimerVideo.com","Programando Java",LocalDateTime.of(2021,8,21,20,20),15);	
			usuariController.altaVideo(video1);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());			
			videoController = new VideoController(video1); 
			videoController.altaTag("Programación");
			videoController.altaTag("Java");
			
			
			//****** creación del video 2 con fecha actual *****
			Video video2 = new Video("http://www.miSegundoVideo.com","Editar Imágenes con Gimp",LocalDateTime.now(),30);
			usuariController.altaVideo (video2);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());
			videoController = new VideoController(video2);
			videoController.altaTag("Instalación Gimp");
			videoController.altaTag("Configuración Gimp");
			
			//****** creación del video 3 con fecha actual *****
			// modificar fecha para que la diferencia ses entre 1 y 3 minutos con la hora actual
			
			Video video3 = new Video("http://www.TercerVideo.com","Instalación linux",LocalDateTime.of(2021,8,22,11,32),40);
			usuariController.altaVideo (video3);
			campsBuits.comprovarCampsBuitsVideo(usuariController.getVideo());			
			videoController = new VideoController(video3); 
			videoController.altaTag("Linux");
			videoController.altaTag("InstalaciónLinux");
			
			//******* thread *********
			// muestra datos video
			Runnable runnable = new VideoAltaHilos(usuari, usuariController);
			Thread thread = new Thread(runnable);
			thread.start();
			thread.join();			
			
			/**
			 * NIVEL 3
			 */
			
			System.out.println("\nPARA PAUSAR/REANUDAD EL VIDEO TECLA + INTRO.");
			System.out.println("\nPulse una tecla para reproducir los videos...");			
			scanner.next();
			// Clase ejecutar video
			EjecutarVideo ejecutarVideo1 = new EjecutarVideo(video1);
			EjecutarVideo ejecutarVideo2 = new EjecutarVideo(video2);
			EjecutarVideo ejecutarVideo3 = new EjecutarVideo(video3);
			
			
			ejecutarVideo1.start();
			scanner.next();
			ejecutarVideo1.suspend();
			scanner.next();
			if(ejecutarVideo1.isAlive()) {
				ejecutarVideo1.resume();				
			}
			
			
			ejecutarVideo2.start();
			scanner.next();
			ejecutarVideo2.suspend();
			scanner.next();
			if(ejecutarVideo2.isAlive()) {
				ejecutarVideo1.resume();				
			}
			
			
			ejecutarVideo3.start();
			scanner.next();
			ejecutarVideo3.suspend();
			scanner.next();
			if(ejecutarVideo3.isAlive()) {
				ejecutarVideo1.resume();				
			}
			
			ejecutarVideo1.join();
			ejecutarVideo2.join();
			ejecutarVideo3.join();
			scanner.close();	

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				
	}
	

}
