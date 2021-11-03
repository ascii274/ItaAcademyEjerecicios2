package com.ascii274.practicas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ascii274.practicas.models.Jugador;
import com.ascii274.practicas.repository.JugadorsDAO;

@RestController
@RequestMapping("/jocdedaus")
public class Controller {
	
	@Autowired //inyeccion de dependencias
	private JugadorsDAO JugadorDAO;
	
	// crea jugador -> Postman ok
	/**
	 * POST: /players : crea un jugador 
	 * @param jugador
	 * @return
	 */
	@PostMapping(value="/jugador")
	public ResponseEntity<Jugador> creaJugador(@RequestBody Jugador jugador){				
		Jugador newJugador = JugadorDAO.save(jugador);
		return ResponseEntity.ok(newJugador);
	}
	// crea jugador -> Postman ok
	/**
	 * PUT /players : modifica el nom del jugador 
	 * @return
	 */
	@GetMapping(value="/jugador")
	public ResponseEntity <List<Jugador>> creaJugador2(){
		List<Jugador> jugadors = JugadorDAO.findAll();
		return ResponseEntity.ok(jugadors);
	}
	
	// modificar -> Postman ok
	/**
	 * POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.  
	 * @param idUsuario
	 * @param jugador
	 * @return
	 */
	@PutMapping (value="/jugador/{ID}")
	public String modificarUsuario(@PathVariable("ID") int idUsuario, @RequestBody Jugador jugador) {
		if(JugadorDAO.existsById(idUsuario)) {
			JugadorDAO.save(jugador);
			return "modificado";			
		}else {
			return "Error al modificar";
		}		
	}
	
	
	//DELETE /players/{id}/games: elimina les tirades del jugador 
	@DeleteMapping(value="/jugador/{ID}/jocs")
	public String eliminaTiradesJugador(@PathVariable("ID") int idUsuario){		
		return "continuar rellenando";
	}
	
	
	
	// prueba get anonim
	@GetMapping(value="/anonim")
	public ResponseEntity<Jugador> getJugador(){
		Jugador jugador = new Jugador();
		jugador.setId(1);
		jugador.setNom("Anonimo");
		return ResponseEntity.ok(jugador);
	}
	
	
	// prueba-> borra
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

}
