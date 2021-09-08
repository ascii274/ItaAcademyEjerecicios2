package com.ascii274.domain;

public class ExecutarCoet extends Thread {
	private Coet coet;
		
	
	public ExecutarCoet(Coet coet) {		
		this.coet = coet;	
	}
	
	public void run() {
		while(true) {
			try {
				coet.mostrarDadesCoet();
				Thread.sleep(1000);
				coet.accelerar();			
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
		}
	}

}
