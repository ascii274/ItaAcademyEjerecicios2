package com.ascii274.practicas.controller;

import java.util.Comparator;

import com.ascii274.practicas.models.Ranking;

public class RankingController implements Comparator<Ranking>{
	
	public int compare(Ranking r1, Ranking r2) {
	double resultado = r1.getMediaExit() - r2.getMediaExit();
	
	if(resultado>0) return -1;
	if(resultado<0) return 1;
	return 0;
}

}
