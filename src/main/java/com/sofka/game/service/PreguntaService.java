package com.sofka.game.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.game.entity.Nivel;
import com.sofka.game.entity.Pregunta;
import com.sofka.game.repository.PreguntaRepository;

@Service
@Transactional
public class PreguntaService {
	@Autowired
	PreguntaRepository repository;

	public Pregunta create(String enunciado, Nivel nivel) {
		Pregunta pregunta = new Pregunta();

		pregunta.setNivel(nivel);
		pregunta.setPregunta(enunciado);
		pregunta = repository.save(pregunta);

		return pregunta;
	}
	
	public List<Pregunta> obtenerPreguntasNivel(Nivel nivel){
		List<Pregunta> preguntas = repository.findByNivel(nivel);
		
		return preguntas;
	}

}
