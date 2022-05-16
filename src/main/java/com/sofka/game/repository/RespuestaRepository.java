package com.sofka.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sofka.game.entity.Pregunta;
import com.sofka.game.entity.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
	List<Respuesta> findByPregunta(Pregunta pregunta);

}
