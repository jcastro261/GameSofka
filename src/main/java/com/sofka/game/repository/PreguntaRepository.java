package com.sofka.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sofka.game.entity.Nivel;
import com.sofka.game.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

	List<Pregunta> findByNivel(Nivel nivel);

}
