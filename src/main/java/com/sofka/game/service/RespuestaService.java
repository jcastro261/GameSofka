package com.sofka.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.game.entity.Pregunta;
import com.sofka.game.entity.Respuesta;
import com.sofka.game.repository.RespuestaRepository;

@Service
public class RespuestaService {

	@Autowired
	RespuestaRepository repository;

	public Respuesta create(String textoRespuesta, Pregunta pregunta, boolean estado) {
		Respuesta respuesta = new Respuesta();

		respuesta.setPregunta(pregunta);
		respuesta.setRespuesta(textoRespuesta);
		respuesta.setEstado(estado);

		respuesta = repository.save(respuesta);

		return respuesta;
	}

	public List<Respuesta> obtenerRespuestasPregunta(Pregunta pregunta) {
		List<Respuesta> respuestas = repository.findByPregunta(pregunta);

		return respuestas;
	}
}
