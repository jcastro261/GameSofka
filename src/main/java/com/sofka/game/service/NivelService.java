package com.sofka.game.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofka.game.entity.Nivel;
import com.sofka.game.repository.NivelRepository;

@Service
@Transactional
public class NivelService {

	@Autowired
	NivelRepository repository;

	public Nivel create(int idNivel) {
		Nivel nivel = new Nivel();

		nivel.setNivel(idNivel);
		nivel.setPremio(idNivel * 10);

		nivel = repository.save(nivel);

		return nivel;
	}
	
	public List<Nivel> findByNivel(int nivel) {
		List<Nivel> nivels = repository.findByNivel(nivel);
		
		return nivels;
		
	}
}
