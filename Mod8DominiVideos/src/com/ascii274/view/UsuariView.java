package com.ascii274.view;

import com.ascii274.domain.Usuari;

public class UsuariView {
	
	public UsuariView() {		
	}
	
	public void printUsuariView(Usuari usuari) {
		System.out.println("\nUsuari[Nom:" + usuari.getNom() + ", Cognom:"+ usuari.getCognom()  + 
				", Password:" + usuari.getPassWord() + "]");
	}

}
