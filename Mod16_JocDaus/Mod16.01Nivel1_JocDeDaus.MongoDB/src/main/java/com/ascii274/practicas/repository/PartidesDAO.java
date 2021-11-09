package com.ascii274.practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ascii274.practicas.models.Jugador;
import com.ascii274.practicas.models.Partida;



public interface PartidesDAO extends JpaRepository<Partida, Integer> {		
	List<Partida> findPartidesByIdUsuari( int id);
    boolean existsPartidesByIdUsuari(int id);
    int deletePartidesByIdUsuari( int id);
}