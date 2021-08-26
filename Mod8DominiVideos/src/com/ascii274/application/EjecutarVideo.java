package com.ascii274.application;


import com.ascii274.domain.EstatEnum;
import com.ascii274.domain.Video;

public class EjecutarVideo extends Thread{
	private Video video;
	
	public EjecutarVideo(Video video) {
		this.video = video;
	}
	
	public void run() {
		try {
			//while (!isInterrupted()) {
			//if(!this.isInterrupted()) {
				video.reproducirVideo();
				Thread.sleep(500);			
			//}
			
		} catch (InterruptedException e) {
			// es interrumpido, cambiamos estado y mostramos los datos.
			//NO CONSIGO QUE ENTRE
			video.setEstatusEnum(EstatEnum.PARAT);
			System.out.println(" ********** El video se ha parado "+ getName() + " **********");
//			System.out.println(" ********** Estado Video: "+ video.getEstatusEnum() + " **********");		
			}		
		System.out.println(" ********** Video: " + video.getTitol() + " FINALIZADO **********");
		System.out.println(" ********** PULSE -> TECLA+INTRO -> TECLA+INTRO PARA CONTINUAR**********");
		}
	

}
