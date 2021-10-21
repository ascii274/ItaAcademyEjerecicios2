package com.ascii274.practica.rest;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ascii274.practica.models.Botiga;

@RestController
@RequestMapping("/botigues")

public class ControllerRest {
	@GetMapping
	public ResponseEntity<Botiga> getBotiga(){
		Botiga botiga = new Botiga();
		botiga.setId(1);
		botiga.setNom("Botiga 1");
		botiga.setCapacitatProductes(200);
		return ResponseEntity.ok(botiga);		
	}

}
