package com.ascii274.practica.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ascii274.practica.dao.BotiguesDAO;
import com.ascii274.practica.dao.QuadresDAO;
import com.ascii274.practica.models.Botiga;
import com.ascii274.practica.models.Quadre;

@RestController
@RequestMapping("/whitecollar")

public class ControllerRest {
	
	@Autowired
	private BotiguesDAO botiguesDAO;
	@Autowired
	private QuadresDAO quadresDAO;

	/**
	 * -Crear botiga: li direm el nom i la capacitat (POST /shops/).
	 * @param botiga
	 * @return
	 */
	@PostMapping(value="/shops")
	public ResponseEntity<Botiga> crearBotiga(@RequestBody Botiga botiga){
		Botiga newBotiga = botiguesDAO.save(botiga);
		return ResponseEntity.ok(newBotiga);
	}

	/**
	 * - Llistar botigues: retorna la llista de botigues amb el seu nom
	 *   i la capacitat (GET /shops/).
	 * @return
	 */
	@GetMapping(value="/shops")
	public ResponseEntity<List<Botiga>> getBotiga(){
		List<Botiga> botigues =botiguesDAO.findAll();
		return ResponseEntity.ok(botigues);
	}


	/**
	 * - Afegir quadre: li donarem el nom del quadre
	 * 	 i el del autor (POST /shops/{ID}/pictures)
	 * @param quadre
	 * @return
	 */
	@PostMapping(value="/shops/{ID}/pictures")
	public ResponseEntity<Quadre> crearQuadre(@RequestBody Quadre quadre,
											  @PathVariable("ID") Integer tiendaId){
		quadre.setBotigaId(tiendaId);
		Quadre newQuadre = quadresDAO.save(quadre);
		return ResponseEntity.ok(newQuadre);
	}
	//Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	
	/**
	 * - Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	 * @param botiga_id
	 * @return
	 */
	@GetMapping(value = "/shops/{ID}/pictures")
	public ResponseEntity<List<Quadre>> getQuadreBotiga(@PathVariable ("ID") Integer botigaId){
		List<Quadre> quadresBotiga = new ArrayList<Quadre>();
		quadresBotiga = quadresDAO.findAllByBotigaId(botigaId);
		return ResponseEntity.ok(quadresBotiga);
	}

	/**
	 * Incendiar quadres: per si ve la policia, es poden eliminar tots els 
	 * quadres de la botiga sense deixar rastre (DELETE /shops/{ID}/pictures). 
	 * 
	 * @param productId
	 * @return
	 */
	@DeleteMapping(value="/shops/{ID}/pictures")
	@Transactional
	public ResponseEntity<Void> deleteQuadres(@PathVariable("ID") Integer productId){		
		quadresDAO.deleteQuadresByBotigaId(productId);
		return ResponseEntity.ok(null);
	}

	/**
	 * - El ejercicio no lo pide
	 * - Mostra tots els quadres.
	 * @return
	 */
	@GetMapping(value="/pictures")
	public ResponseEntity<List<Quadre>> getQuadre(){
		List<Quadre> quadres =quadresDAO.findAll();
		return ResponseEntity.ok(quadres);
	}


	/**
	 * -Mostra quadres per id
	 * - url: localhost:8080/whitecollar/pictures/id
	 * @param pictureId
	 * @return
	 */
	@RequestMapping(value ="/pictures/{pictureId}")
	public ResponseEntity<Quadre> getQuadreById(@PathVariable("pictureId") Integer pictureId){
		Optional<Quadre> optionalQuadre = quadresDAO.findById(pictureId);
		if(optionalQuadre.isPresent()) {
			return ResponseEntity.ok(optionalQuadre.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/**
	 * - Actualització de quadres per cada tienda
	 * - No es demana a l'exercici
	 * @param quadre
	 * @return
	 */
	@PutMapping ("/update/shops/{id}") 
	public ResponseEntity<Quadre> updateQuadre(@RequestBody Quadre quadre){
		Optional<Quadre> optional = quadresDAO.findById(quadre.getId());
		if(optional.isPresent()) {
			Quadre updateQuadre = optional.get();
			updateQuadre.setNom(quadre.getNom());			
			quadresDAO.save(updateQuadre);
			return ResponseEntity.ok(updateQuadre);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	/*****************/
	/*** PRRUEBAS ****/
	/*****************/
//	
//	/**
//	 * - Prueba Helllo World
//	 * @return
//	 */
//	@GetMapping("/")
//	public String index() {
//		return "Hello World";
//	}
//
//	/**
//	 * - prueba GET
//	 */
//	@GetMapping(value="/getexample")
//	public ResponseEntity<Botiga> getBotigaExample(){
//		Botiga botiga = new Botiga();
//		botiga.setId(1);
//		botiga.setNom("Botiga 1");
//		return ResponseEntity.ok(botiga);
//	}	
	
}
