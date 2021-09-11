package com.ascii274.view;

import com.ascii274.domain.Coet;
import com.ascii274.domain.ExecutarCoet;
import com.ascii274.domain.Propulsor;

public class MainCoets {
	/**
	 * Version 2. 
	 * Nivel 1 finalizado.
	 * Nivel 2 finalizado.
	 */
	
	public static void main (String[] args) {
		//int[] propulsor1 = new int[] {10,30,80};
		//int[] propulsor2 = new int[] {30,40,50,50,30,10};
		Coet coet1 = new Coet("32WESSDS");
		
		coet1.agregarPropulsor(new Propulsor(coet1,"1", 10));
		coet1.agregarPropulsor(new Propulsor(coet1,"2", 30));
		coet1.agregarPropulsor(new Propulsor(coet1,"3", 80));
		
		Coet coet2 = new Coet("LDSFJA32");
		coet2.agregarPropulsor(new Propulsor(coet2,"1", 30));
		coet2.agregarPropulsor(new Propulsor(coet2,"2", 40));
		coet2.agregarPropulsor(new Propulsor(coet2,"3", 50));
		coet2.agregarPropulsor(new Propulsor(coet2,"4", 50));
		coet2.agregarPropulsor(new Propulsor(coet2,"5", 30));
		coet2.agregarPropulsor(new Propulsor(coet2,"6", 10));
		
		ExecutarCoet executarCoet1 = new ExecutarCoet(coet1);
		ExecutarCoet executarCoet2 = new ExecutarCoet(coet2);
		executarCoet1.start();
		executarCoet2.start();
		
	}

}
