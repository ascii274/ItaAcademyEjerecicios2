package com.ascii274.practicas.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.ascii274.practicas.models.Jugador;


/* ***************************************
 * NomArchivoDAO / NomArchviosRepository
 * **************************************
 */
public interface JugadorsDAO extends MongoRepository<Jugador, Integer> {	
	
}
