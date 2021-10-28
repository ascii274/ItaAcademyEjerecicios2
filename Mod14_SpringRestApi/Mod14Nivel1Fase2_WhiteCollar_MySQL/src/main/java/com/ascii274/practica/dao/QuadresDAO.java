package com.ascii274.practica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ascii274.practica.models.Botiga;
import com.ascii274.practica.models.Quadre;


public interface QuadresDAO extends JpaRepository<Quadre, Integer>{
	List<Quadre> findAllByBotigaId(int botiga_id);
	void deleteQuadresByBotigaId(int botiga_id);

}
