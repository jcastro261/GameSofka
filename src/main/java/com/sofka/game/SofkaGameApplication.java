package com.sofka.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sofka.game.service.NivelService;
import com.sofka.game.service.PreguntaService;
import com.sofka.game.service.RespuestaService;
import com.sofka.game.view.Juego;

@SpringBootApplication
public class SofkaGameApplication implements CommandLineRunner {
	
	@Autowired
	NivelService nivelService;
	
	@Autowired
	PreguntaService preguntaService;
	
	@Autowired
	RespuestaService respuestaService;

	public static void main(String[] args) {
		SpringApplication.run(SofkaGameApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		nivelService.create(1);
		System.setProperty("java.awt.headless", "false");

		Juego juego = new Juego();
		
		juego.setNivelService(nivelService);
		juego.setPreguntaService(preguntaService);
		juego.setRespuestaService(respuestaService);
		juego.menuJuego();
	}

}
