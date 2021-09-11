package com.ascii274.domain;



public class Coet {
	private String nombre;
	private int potenciaActual;
	private int potenciaObjectiu;// = potencia máxima =  1 valor propulsors
	private int[] propulsors;
	private int potenciaMaxima;
	private boolean alcanzadoPotenciaObjetivo = false;
	
	
	public Coet(String nombre, int[] propulsors) {
		//potenciaMaxima = propulsors[(int) (Math.random()*3)];// escogemos un valor dentro de propulsores
		this.nombre = nombre;		
		this.potenciaObjectiu=0;
		this.propulsors = propulsors;
		potenciaActual = 0;
		potenciaMaxima=0;		
	}
	
	
	/**
	 * Comprueba si se ha llegado a la velocidad del objetivo.
	 *
	 */
	//public synchronized void accelerar() {// ejecuta por orden
	public void accelerar() {	
		try {
			
			potenciaMaxima = propulsors[(int) (Math.random()*3)];// escogemos un valor dentro de propulsores
			potenciaObjectiu = potenciaMaxima;
			//int potenciaMaxima=potenciaObjectiu;
			if (alcanzadoPotenciaObjetivo) {
				frenar();
			} else {
				while (potenciaActual <= potenciaObjectiu) {					
					potenciaMaxima = potenciaObjectiu; // no lo veo muy claro.preguntar.
					System.out.println(nombre + "-" + Thread.currentThread().getId() + " Potencia conseguida:"
							+ potenciaActual + " " + potenciaObjectiu + " " + potenciaMaxima);					
					potenciaActual++; // sumamos potencia
					Thread.sleep((int) (Math.random() * 1000));
				}
				alcanzadoPotenciaObjetivo = true;
				System.out.println("\n######" + nombre + " " + Thread.currentThread().getId() + " ha alcanzado el objetivo. !! FRENANDO !! ######");
				potenciaObjectiu =0;//cambiamos de objetivo, frenamos 
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public void frenar() {
		try {

			if (alcanzadoPotenciaObjetivo) {
				alcanzadoPotenciaObjetivo = false;
				while (potenciaActual >= potenciaObjectiu) {
					System.out.println(nombre + "-" + Thread.currentThread().getId() + " Potencia conseguida:"
							+ potenciaActual + " " + potenciaObjectiu + " " + potenciaMaxima);
					potenciaActual--;
					Thread.sleep((int) (Math.random() * 1000));
				}
				potenciaObjectiu=potenciaMaxima; // igualamos la potenciaObjectiu
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	// mostra totes les dades del coet.
	public void mostrarDadesCoet() {
		String propulsorsToString="";
		for(int i=0; i<propulsors.length; i++) {
			propulsorsToString +=propulsors[i] + " ";
		}
		System.out.println("Rocket id=" + nombre  + " Potència Màxima propulsors: [" + propulsorsToString + "]");		
	}
	
	// getters setters	
	public String getNombre() {
		return nombre;
	}
	
	public int damePotenciaTotal() {
		//suma de todos los propulsores
		int sumaPropulsors = 0; 
		for(int i=0; i<propulsors.length;i++) {
			sumaPropulsors +=propulsors[i];			
		}
		return sumaPropulsors;
	}
	

}
