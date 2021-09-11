package com.ascii274.domain;

public class ExecutarCoet extends Thread {
	private Coet coet;
	
	public ExecutarCoet(Coet coet) {		
		this.coet = coet;			
	}
	
	public void run() {
			try {
				coet.ejecutarPropulsor();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
	}
	


}
