package com.ascii274.domain;

import java.util.ArrayList;
import java.util.List;

public class Coet {
	private String nombre;	
	private List<Propulsor> propulsors = new ArrayList<Propulsor>();	
	
	public Coet(String nombre) {
		this.nombre = nombre;	
	}
	
	public void agregarPropulsor(Propulsor propulsor) {
		propulsors.add(propulsor);		
	}

	public void ejecutarPropulsor() {
//		for (int i = 0; i < propulsors.size(); i++) {
//			propulsor = propulsors.get(i);
//			propulsor.start();		
//		}
		// probando lambda		
		//mostramos mensaje que iniciamos los propulsores
		propulsors.forEach(x->System.out.println("Iniciando propulsores: " + x));
		propulsors.forEach(propulsor->propulsor.start()); //iniciamos propulsores del coete.
	}
	

	public String getNombre() {
		return nombre;
	}

	public List<Propulsor> getPropulsors() {
		return propulsors;
	}


}
