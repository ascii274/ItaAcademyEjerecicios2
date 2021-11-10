package com.ascii274.practicas.models;


public class Ranking {

	private int idUsuari;
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


