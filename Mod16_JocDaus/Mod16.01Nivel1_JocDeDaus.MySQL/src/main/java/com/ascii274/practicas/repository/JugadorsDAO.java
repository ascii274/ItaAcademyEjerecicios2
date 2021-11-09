package com.ascii274.practicas.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.ascii274.practicas.models.Jugador;
import com.ascii274.practicas.models.Partida;



public interface JugadorsDAO extends JpaRepository<Jugador, Integer> {	
	
}
