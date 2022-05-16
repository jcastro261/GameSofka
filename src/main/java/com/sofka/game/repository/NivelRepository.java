package com.sofka.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sofka.game.entity.Nivel;

@Repository
public interface NivelRepository extends JpaRepository<Nivel, Long> {
	
	List<Nivel> findByNivel(int idNivel);

}
