package com.ascii274.view;

import com.ascii274.domain.Coet;
import com.ascii274.domain.ExecutarCoet;

public class MainCoets {
	
	public static void main (String[] args) {
		int[] propulsor1 = new int[] {10,30,80};
		int[] propulsor2 = new int[] {30,40,50,50,30,10};
		Coet coet1 = new Coet("32WESSDS", propulsor1);//nom; propulsors; potenciaObjectiu
		Coet coet2 = new Coet("LDSFJA32", propulsor2);
		ExecutarCoet executarCoet1 = new ExecutarCoet(coet1);
		ExecutarCoet executarCoet2 = new ExecutarCoet(coet2);
		executarCoet1.start();
		executarCoet2.start();
		
	}

}
