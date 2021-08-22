package com.ascii274.application;

import com.ascii274.domain.Usuari;
import com.ascii274.domain.Video;


public class CampsBuits {
	public boolean comprovarCampsBuitsVideo(Video video) throws Exception{
		if(video == null) throw new Exception("Comporovar camps.El video es null");
		if(isEmptyString(video.getTitol())) throw new Exception("Campo titulo es obligatorio");
		if(isEmptyString(video.getUrl()))  throw new Exception("Campo url es obligatorio");		
		return true;
	}
	// null or ""??
	public boolean comprovarCampsBuitsUsuari(Usuari usuari) throws Exception{
		if(usuari == null) throw new Exception("El usuario esta vacío");
		if(isEmptyString(usuari.getNom())) throw new Exception("Campo nombre és obligatorio");
		if(isEmptyString(usuari.getCognom())) throw new Exception("Campo cognom és obligatorio");
		return true;
	}
	
	public boolean isEmptyString(String string) {
		return string == null || string.isEmpty();		
	}
	
	
}
