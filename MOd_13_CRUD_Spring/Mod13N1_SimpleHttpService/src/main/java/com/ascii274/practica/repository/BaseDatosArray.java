package com.ascii274.practica.repository;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.stream.Stream;
import com.ascii274.practica.bean.Empleat;
import com.ascii274.practica.bean.EnumFeina;


public class BaseDatosArray {
	ArrayList<Empleat> empleats = new ArrayList<>();
	
	public BaseDatosArray() {
		empleats.add(new Empleat("Pedro", EnumFeina.Cloud_System_Engineer));
		empleats.add(new Empleat("Eva",EnumFeina.Data_Scientist));
		empleats.add(new Empleat("Oscar",EnumFeina.Database_Administrator));
		empleats.add(new Empleat("Laura",EnumFeina.IT_Director));
		empleats.add(new Empleat("Juan",EnumFeina.IT_Technician));
		empleats.add(new Empleat("Alex",EnumFeina.QA_Tester));
		empleats.add(new Empleat("Rubén",EnumFeina.Software_Engineer));
		empleats.add(new Empleat("Vanesa",EnumFeina.Support_Specialist));
		empleats.add(new Empleat("Marta",EnumFeina.UX_Designer));
		empleats.add(new Empleat("Carlos",EnumFeina.Web_Administrator));
		empleats.add(new Empleat("Ana",EnumFeina.Web_Developer));
		
	}
	
	public ArrayList<Empleat> getEmpleats(){
		return empleats;
	}
	
	public void setEmpleats(ArrayList<Empleat> empleats) {
		this.empleats = empleats;
	}
	
	public void modifica(Empleat empleat) {
		Iterator<Empleat> it = empleats.iterator();
		while (it.hasNext()) {
			Empleat emp =  it.next();
			if(emp.getId() == empleat.getId()) {
				emp.setNom(empleat.getNom());
				emp.setFaena(empleat.getFaena());
				break;
			}			
		}		
	}
	
	public Empleat getEmpleat(int id) {
		boolean encontrado = false;
		int contador=0;
		Empleat empleat = null;
		while(!encontrado) {
			if(empleats.get(contador).getId() == id ) {
				empleat = empleats.get(contador);
				encontrado = true;				
			}
			contador ++;			
		}
		return empleat;
	}
	
	public void inserta(Empleat empleat) {
		empleats.add(empleat);
	}
	
	public void borra(int id) {
		Iterator<Empleat> it = empleats.iterator();
		while (it.hasNext()) {
			Empleat empleat = it.next();
			if(empleat.getId() == id) {
				it.remove();
				break;				
			}			
		}
	}
	
	
	
	/**
	 * - Busqueda  per  el camp faena
	 * @param jobSearch
	 * @return
	 */
	
	public ArrayList<Empleat> returnJobsSearch(String jobSearch){	
		ArrayList<Empleat> newEmpleatsSearch = new ArrayList<Empleat>();
		Empleat empleat;
		for(int i=0; i<empleats.size();i++) {
			if(empleats.get(i).getFaena().getNomTreball().contains(jobSearch) ) {
				empleat = empleats.get(i);
				newEmpleatsSearch.add( empleat);
			}			
		}
		return newEmpleatsSearch;		
	}

}
