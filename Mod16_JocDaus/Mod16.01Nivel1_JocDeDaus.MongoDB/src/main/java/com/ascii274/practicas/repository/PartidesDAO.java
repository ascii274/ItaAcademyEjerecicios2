package com.ascii274.practicas.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ascii274.practicas.models.Partida;


public interface PartidesDAO extends MongoRepository<Partida, Integer> {		
	List<Partida> findPartidesByIdUsuari( int id);
    boolean existsPartidesByIdUsuari(int id);
    int deletePartidesByIdUsuari( int id);
}