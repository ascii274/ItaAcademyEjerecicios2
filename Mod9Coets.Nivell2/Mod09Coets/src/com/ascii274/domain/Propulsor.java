package com.ascii274.domain;

public class Propulsor extends Thread{
	private String idPropulsor;		
	private int potenciaActual;
	private int potenciaObjectiu;// = potencia máxima =  1 valor propulsors
	private int potenciaMaxima;
	private Coet coet;
	private boolean avanzar = true;
	
	public Propulsor(Coet coet,String idPropulsor, int potenciaPropulsor) {
		this.coet = coet;
		this.idPropulsor = idPropulsor;
		this.potenciaMaxima = potenciaPropulsor;
		potenciaActual =0;				
		potenciaObjectiu = potenciaMaxima;
	}
	
	public void run() {
		accelerar();
	}
	
	/**
	 * metodos que avanza hasta llegar al objetivo = potenciaMaxima
	 */
	public void accelerar() {			
		try {
			while (true) {
				if (!avanzar) {					
					frenar();

				} else {
					while (potenciaActual < potenciaObjectiu) {											
						potenciaActual++;
						
						if(potenciaActual==5) {//iniciamos vuelo al espacio
							System.out.println("Potencia necesaria:" + damePotenciaNecesaria(potenciaActual));
							iniciarVueloEspacial(potenciaActual);
						}
						
						System.out.println(toString()); // mostramos datos propulsores
						Thread.sleep((int) (Math.random() * 1000));
					}
					// mostramos propulsor ha llegado su limite					
					System.out.println(
							"### El propulsor: " + idPropulsor + " ha llegado a su limite: " + potenciaObjectiu + " ###");
					avanzar = false;
					// cambiamos objetivo reducimos
					potenciaObjectiu = 0;					
				}
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  reduce la potenciaActual hasta llegar a 0
	 */
	public void frenar() {
		try {
			if (!avanzar) {//reduciendo
				System.out.println(
						"### El propulsor: " + idPropulsor + " esta reduciendo: " + potenciaMaxima + " ###");
				while (potenciaActual >= potenciaObjectiu) {
					System.out.println(toString()); // mostramos datos propulsores
					potenciaActual--;
					Thread.sleep((int) (Math.random() * 1000));
				}
				System.out.println(
						"### El propulsor: " + idPropulsor + " ha llegado a su limite: " + potenciaObjectiu + " ###");
				potenciaObjectiu = potenciaMaxima; // igualamos la potenciaObjectiu
				avanzar = true;// false porque retrocedemos

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * devuelve la suma de las potencias del propulsor
	 * @return sumaTotal;
	 */
	public int dameValorPotenciaTotal() {
		int sumaTotal=0;
		//coet.getPropulsors().forEach(x -> =+x);
		for(int i=0;i<coet.getPropulsors().size(); i++) {
			sumaTotal += coet.getPropulsors().get(i).getPotenciaMaxima();			
		}
		return sumaTotal;
	}
	
	/**
	 * devuelve potencia necesaria para cada propulsor.
	 * @param potenciaActual
	 * @return velocidad; -> potencia necesaria de cada propulsor
	 */
	public int damePotenciaNecesaria(int potenciaActual) {
		int velocidad=0;
		velocidad =(int) (potenciaActual + 100 * Math.sqrt(dameValorPotenciaTotal())) / coet.getPropulsors().size();
		return velocidad;
		
	}
	
	/**	 
	 * inicia vuelo en el espacio segun valor de la potencia necesaria.
	 * @param potenciaActual
	 * 
	 */
	public void iniciarVueloEspacial(int potenciaActual) {
		int potenciaNecesaria = damePotenciaNecesaria(potenciaActual);
		if(potenciaNecesaria > potenciaMaxima) {
			System.out.println(coet.getNombre()+ " " + idPropulsor + " La potencia necesaria:" + potenciaNecesaria + " es mayor a la maxima del propulsor:" + potenciaMaxima);
		}else {
			// igualamos  potencia
			potenciaActual = potenciaNecesaria;
		}
		
	}
	
	//getter setter	
	public int getPotenciaActual() {
		return potenciaActual;
	}
	
	public void setPotenciaActual(int potenciaActual) {
		this.potenciaActual += potenciaActual;
		
	}

	public int getPotenciaObjectiu() {
		return potenciaObjectiu;
	}
	
	public void setPotenciaObjectiu(int potenciaObjectiu) {
		this.potenciaObjectiu = potenciaObjectiu;
		
	}
	
	public int getPotenciaMaxima() {
		return potenciaMaxima;
	}

	// mostrar dades
	public String toString( ) {	
		//return idPropulsor + "[" + potenciaActual + " " + potenciaObjectiu + " " + potenciaMaxima +"]";
		return coet.getNombre()+ " " + idPropulsor + "[" + potenciaActual + " " + potenciaObjectiu + " " + potenciaMaxima +"]";		
	}
	
	
	
}
