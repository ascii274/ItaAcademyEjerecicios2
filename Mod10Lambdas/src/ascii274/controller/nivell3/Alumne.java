package ascii274.controller.nivell3;

public class Alumne {
	private String nom;
	private int edat;
	private CursEnum curs;
	private double nota;
	
	public Alumne(String nom, int edat, CursEnum curs, double nota) {
		this.nom = nom;
		this.edat = edat;
		this.curs = curs;
		this.nota = nota;
	}
	
	

	public String getNom() {
		return nom;
	}



	public int getEdat() {
		return edat;
	}



	public CursEnum getCurs() {
		return curs;
	}



	public double getNota() {
		return nota;
	}



	public String toString() {
		return "Alumne[Nombre:" + nom + " ,Edat:" + edat + 
				" , Curs:"  + curs +  " , Nota:" + nota +   "]";	
		}
}
