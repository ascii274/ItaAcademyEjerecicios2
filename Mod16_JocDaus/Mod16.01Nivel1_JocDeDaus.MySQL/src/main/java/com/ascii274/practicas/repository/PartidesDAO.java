package com.ascii274.practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ascii274.practicas.models.Partida;

public interface PartidesDAO extends JpaRepository<Partida, Integer>{

}
