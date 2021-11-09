package com.ascii274.practicas.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ascii274.practicas.models.Jugador;
import com.ascii274.practicas.models.Partida;



/* ***************************************
 * NomArchivoDAO / NomArchviosRepository
 * **************************************
 */
public interface JugadorsDAO extends MongoRepository<Jugador, Integer> {	
	
}
