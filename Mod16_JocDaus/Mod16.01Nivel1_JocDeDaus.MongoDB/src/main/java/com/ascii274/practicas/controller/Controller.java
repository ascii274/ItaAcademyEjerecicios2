package com.ascii274.practicas.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ascii274.practicas.models.Jugador;
import com.ascii274.practicas.models.Partida;
import com.ascii274.practicas.models.Ranking;
import com.ascii274.practicas.repository.JugadorsDAO;
import com.ascii274.practicas.repository.PartidesDAO;




/**
 * *****************************
 * ***** SERVICIOS API REST ****
 * *****************************
 * @author joel
 *
 */
@RestController
@RequestMapping("/jocdedaus")
public class Controller {
	
	@Autowired //inyeccion de dependencias
	private JugadorsDAO jugadorsDAO;	
	@Autowired
	private PartidesDAO partidesDAO;
//	@Autowired
//	private RankingDAO rankingDAO;
	
	public Controller() {	
	
	}
 
	/**
	 * -POST: /players : crea un jugador
	 * -Postman ok 
	 * -Mongo Compass ok.
	 * @param jugador
	 * @return
	 */
	@PostMapping(value="/players")
	public ResponseEntity<Jugador> creaJugador(@RequestBody Jugador jugador){				
		Jugador newJugador = jugadorsDAO.save(jugador);
		return ResponseEntity.ok(newJugador);
	}

 
	/**
	 * -PUT /players : modifica el nom del jugador	 
	 * -Postman ok 
	 * 
	 * @param idUsuario
	 * @param jugador
	 * @return
	 */
	@PutMapping (value="/players/{ID}")
	public String modificarUsuario(@PathVariable("ID") int idUsuario, @RequestBody Jugador jugador) {
		if(jugadorsDAO.existsById(idUsuario)) {
			jugadorsDAO.save(jugador);
			return "modificado";			
		}else {
			return "Error al modificar";
		}		
	}
	
	// 
	/**
	 * -POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	 * -Postman ok.   
	 * @param idUsuari
	 * @param partida
	 */
	@PostMapping(value="/players/{ID}/games")		
	public ResponseEntity<Partida> creaPartida(@PathVariable("ID") Integer idUsuari,@RequestBody Partida partida) {
	//public void creaPartida(@PathVariable("idUsuari") Integer idUsuari,@RequestBody Partida partida) {
			// asignamos  aleatorio dados
		
		Random random = new Random();
		int maxNum = 6;
		partida.setDau1(random.nextInt(maxNum)+1 );
		partida.setDau2(random.nextInt(maxNum)+1 );		
		if(partida.getDau1() + partida.getDau2()==7) {
			partida.setResultat(true);
		}else {
			partida.setResultat(false);
		}
		Partida newPartida = partidesDAO.save(partida);
		return ResponseEntity.ok(newPartida);		
	}
	
 
	/**
	 * -DELETE /players/{id}/games: elimina les tirades del jugador 
	 * -Postman ok
	 * @param idUsuari
	 * @return
	 */
	@DeleteMapping(value="/players/{ID}/games")
	@Transactional
	public String eliminaTiradesJugador(@PathVariable("ID") Integer idUsuari){
		
		if(jugadorsDAO.findById(idUsuari)  != null && partidesDAO.existsPartidesByIdUsuari(idUsuari)) {
			partidesDAO.deletePartidesByIdUsuari(idUsuari);			
			return "Partides de l'usuari:'" + idUsuari +"' esborrat correctament.";
		}else {
			return "Usuari:'" + idUsuari + "' inexistent.";
		}		
	}
	
	
	/**
	 * -GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits   
	 * -Falta percentatge exit 
	 * -Postman ok. 
	 * -Mongo Compass ok.
	 * @return
	 */
	@GetMapping(value="/players")
	public ResponseEntity <List<Jugador>> getPercentageExitJugadors(){
		List<Jugador> jugadors = jugadorsDAO.findAll();
		return ResponseEntity.ok(jugadors);
	}
	
	
	// obtenir partides jugadores
	/**
	 * GET /players/{id}/games: retorna el llistat de jugades per un jugador.  
	 * - Postman ok.
	 * @param idUsuari
	 * @return
	 */
	@GetMapping(value="/players/{ID}/games")
	public List<Partida> getPartidesJugador(@PathVariable("ID") int idUsuari){		
		if (jugadorsDAO.findById(idUsuari) != null) {
			List<Partida> partides = partidesDAO.findPartidesByIdUsuari(idUsuari);
			return partides;			
		}else {
			return null;
		}		
	}
	
	//
	/**
	 * GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. 
	 * És a dir, el percentatge mig d’èxits.
	 * - Postman -> ok
	 * @return
	 */
	@GetMapping(value="/player/ranking/alljugadors")
	public String findRankingJugadors() {
		List<Partida> partides = partidesDAO.findAll();
		List<Jugador> jugadors = jugadorsDAO.findAll();
		int idJugador=0, cantGanades=0, cantPartides=0;
		double migExits=0.0;
		String cadena ="";
		for(int i=0; i<jugadors.size();i++) {
			idJugador = jugadors.get(i).getId(); //guardem idJugador
			for(int j=0;j<partides.size();j++) {
				if(jugadors.get(i).getId() == partides.get(j).getIdUsuari()) {
					if(partides.get(j).isResultat()) {
						cantGanades ++;						
					}
					cantPartides ++;				
				}				
			}
			// calculem la mitjana
			migExits = (double) (cantGanades * 100 )/ cantPartides  ;
			cadena = cadena + "Ranking[IdJugador:" + idJugador + ", Partides:" + cantPartides 
					+ ", Ganades " + cantGanades + ", Promedio:" + migExits  + "]\n";
			cantPartides =0;//initzialitzem contadorPartides			
			migExits=0.0;
			cantGanades=0;
			cantPartides=0;
		}
		return cadena;	
	}
		
	/**
	 * -GET /players/ranking/loser: retorna el jugador amb millor percentatge d’èxit
	 * -Postman ok
	 * @return
	 */
	@GetMapping(value = "/player/ranking/winner")
	public String getJugadorPercentatgeWinner(){
		List<Ranking> rankings=new ArrayList<Ranking>();
		List<Jugador> jugadors = jugadorsDAO.findAll();
		List<Partida> partides = partidesDAO.findAll();		
		int idJugador=0, cantGanades=0, cantPartides=0;
		double migExits=0.0;
		for(int i=0;i < jugadors.size();i++) {
			idJugador = jugadors.get(i).getId(); //guardem idJugador
			for(int j=0;j<partides.size();j++) {
				if(jugadors.get(i).getId() == partides.get(j).getIdUsuari()) {
					if(partides.get(j).isResultat()) {
						cantGanades ++;						
					}
					cantPartides ++;
				}
			}
			migExits = (double) (cantGanades * 100 )/ cantPartides  ;
			rankings.add(new Ranking(idJugador, migExits));
			cantPartides =0;//initzialitzem contadorPartides
			migExits=0.0;
			cantGanades=0;
			cantPartides=0;
			RankingController rankingController;
			Collections.sort(rankings, new RankingController());
			
		}
		return "Winner" + rankings.get(0).toString(); // primer en el listado
	}
	
	
	/**
	 * -GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit
	 * -Postman ok 
	 * @return
	 */
	@GetMapping (value="/player/ranking/loser")
	public String getJugadorPercentatgeLoser(){
		List<Ranking> rankings=new ArrayList<Ranking>();
		List<Jugador> jugadors = jugadorsDAO.findAll();
		List<Partida> partides = partidesDAO.findAll();		
		int idJugador=0, cantGanades=0, cantPartides=0;
		double migExits=0.0;
		for(int i=0;i < jugadors.size();i++) {
			idJugador = jugadors.get(i).getId(); //guardem idJugador
			for(int j=0;j<partides.size();j++) {
				if(jugadors.get(i).getId() == partides.get(j).getIdUsuari()) {
					if(partides.get(j).isResultat()) {
						cantGanades ++;						
					}
					cantPartides ++;
				}
			}
			migExits = (double) (cantGanades * 100 )/ cantPartides  ;
			rankings.add(new Ranking(idJugador, migExits));
			cantPartides =0;//initzialitzem contadorPartides
			migExits=0.0;
			cantGanades=0;
			cantPartides=0;
			RankingController rankingController;
			Collections.sort(rankings, new RankingController());
			
		}
		return "Loser" + rankings.get(rankings.size()-1).toString(); // el último
	}
	
	
	

	/* **********************
	 * **** COMPARE ****
	 * *********************/
//	public int compare(Ranking r1, Ranking r2) {
//		double resultado = r1.getMediaExit() - r2.getMediaExit();
//		
//		if(resultado>0) return -1;
//		if(resultado<0) return 1;
//		return 0;
//	}
	
//	// prueba GET
//	@GetMapping(value="/anonim")
//	public ResponseEntity<Jugador> getJugador(){
//		Jugador jugador = new Jugador();
//		jugador.setId(1);
//		jugador.setNom("Anonimo");
//		return ResponseEntity.ok(jugador);
//	}
//	
//	// prueba-> borra
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello World";
//	}

}
