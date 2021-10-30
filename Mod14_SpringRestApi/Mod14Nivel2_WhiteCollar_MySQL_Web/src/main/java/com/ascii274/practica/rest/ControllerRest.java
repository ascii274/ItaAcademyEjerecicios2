package com.ascii274.practica.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ascii274.practica.dao.BotiguesDAO;
import com.ascii274.practica.dao.QuadresDAO;
import com.ascii274.practica.models.Botiga;
import com.ascii274.practica.models.Quadre;

@Controller
//@RestController //*
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
	public String getBotigaPost(Botiga botiga, Model model){
		List<Botiga> botigues =botiguesDAO.findAll();
		model.addAttribute("botigues", botigues);
		return "shops";		
	}

	/**
	 * - Llistar botigues: retorna la llista de botigues amb el seu nom
	 *   i la capacitat (GET /shops/).
	 * @return
	 */
	
	@GetMapping(value="/shops")	
	public String getBotiga(Botiga botiga, Model model){
		List<Botiga> botigues =botiguesDAO.findAll();
		model.addAttribute("botigues", botigues);
		return "shops";		
	}


	
	/**
	 * - Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	 * @param botiga_id
	 * @return
	 */
	@GetMapping(value = "/shops/{ID}/pictures")	
	public String getQuadreBotiga (@PathVariable ("ID") Integer botigaId, Model model){
		List<Quadre> quadres = new ArrayList<Quadre>();
		quadres = quadresDAO.findAllByBotigaId(botigaId);
		model.addAttribute("quadres", quadres);
		return "quadres";		
	}
	
	// BORRAR
	@GetMapping(value = "/whitecollar/shops/{ID}")
	public String getQuadreBotiga3 (@PathVariable ("ID") Integer botigaId, Model model){
		List<Quadre> quadres = quadresDAO.findAllByBotigaId(botigaId);	
		model.addAttribute("quadres", quadres);
		return "quadres";		
	}
	
	@PostMapping(value = "/shops/{ID}/pictures")	
	
	public String getQuadreBotiga2 (@PathVariable ("ID") Integer botigaId, Model model){
		List<Quadre> quadres = quadresDAO.findAllByBotigaId(botigaId);	
		model.addAttribute("quadres", quadres);
		return "quadres";		
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
		quadresDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}

	/**
	 * - El ejercicio no lo pide
	 * - Mostra tots els quadres.
	 * @return
	 */
	@GetMapping(value="/pictures")
	public String getQuadre(Model model){
		List<Quadre> quadres =quadresDAO.findAll();
		model.addAttribute("quadres", quadres);
		return "quadres";

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
	
	
}

