package com.ascii274.practicas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ascii274.practicas.models.Jugador;



public interface JugadorsDAO extends JpaRepository<Jugador, Integer> {	
	
}
