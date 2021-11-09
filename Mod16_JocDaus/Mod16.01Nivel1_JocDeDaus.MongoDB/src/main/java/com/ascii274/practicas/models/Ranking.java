package com.ascii274.practicas.models;

//@Entity
public class Ranking {
	
//	@Id
//	@Column(name="idUsuari")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuari;
//	@Column(name="mediaExit")
	private double mediaExit;
	
	public Ranking(int idUsuari, double migExits) {		
		this.idUsuari = idUsuari;
		this.mediaExit = migExits;
	}

	public int getIdUsuari() {
		return idUsuari;
	}


	public double getMediaExit() {
		return mediaExit;
	}

	public String toString() {
		return "[Ranking: idUsuario:" + idUsuari + ", Media Exits:" + mediaExit  +"]"; 
	}
	

}


