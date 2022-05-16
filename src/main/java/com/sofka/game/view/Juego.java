/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.game.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.sofka.game.entity.Nivel;
import com.sofka.game.entity.Pregunta;
import com.sofka.game.entity.Respuesta;
import com.sofka.game.service.NivelService;
import com.sofka.game.service.PreguntaService;
import com.sofka.game.service.RespuestaService;
import com.sofka.game.utils.Constants;

public class Juego {

	private List<HistoricoJuego> historicoJuego;
	private Usuario usuario;

	private PreguntaService preguntaService;

	private NivelService nivelService;

	private RespuestaService respuestaService;

	public Juego() {

		this.historicoJuego = new ArrayList<>();
		usuario = null;
	}

	public void crearPregunta() {

		boolean estado = false;
		RespuestaView resAgregar = null;
		String pregunta = "";
		int nivelPregunta = 0;
		do {
			try {
				pregunta = JOptionPane.showInputDialog(Constants.LABEL_NUEVA_PREGUNTA);
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (pregunta.length() == 0);

		do {
			try {
				nivelPregunta = Integer.parseInt(JOptionPane.showInputDialog("digite el nivel de la pregunta(1-5)"));
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (nivelPregunta < 1 || nivelPregunta > 5);

		Nivel nivel = new Nivel();
		List<Nivel> nivels = nivelService.findByNivel(nivelPregunta);

		if (nivels.size() > 0)
			nivel = nivels.get(0);

		com.sofka.game.entity.Pregunta preguntaDB = preguntaService.create(pregunta, nivel);

		List<Respuesta> respuestas = new ArrayList<Respuesta>();
		for (int i = 0; i < 4; i++) {
			resAgregar = crearRespuesta(estado);
			if (resAgregar.isEstado() == true) {
				estado = true;
			}

			Respuesta respuesta = respuestaService.create(resAgregar.getRespuesta(), preguntaDB, resAgregar.isEstado());
			respuestas.add(respuesta);
		}
		preguntaDB.setRespuestas(respuestas);

		JOptionPane.showMessageDialog(null, preguntaDB.toString());

	}

	public RespuestaView crearRespuesta(boolean estado) {
		String respuesta = "";
		do {
			try {
				respuesta = JOptionPane.showInputDialog("Ingrese el texto de la respuesta");
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (respuesta.length() == 0);

		String esCorrecta = "";
		boolean correcta = false;
		if (estado == false) {
			do {
				try {
					esCorrecta = JOptionPane.showInputDialog("Es la respuesta correcta? [s/n]");
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (!esCorrecta.toLowerCase().equals("s") && !esCorrecta.toLowerCase().equals("n"));
		}

		if (esCorrecta.equals("s") || esCorrecta.equals("S")) {
			correcta = true;
		}
		return new RespuestaView(respuesta, correcta);
	}

	public void menuJuego() {
		boolean estado = true;
		int opcionJuego = 0;
		do {
			do {
				try {
					opcionJuego = Integer.parseInt(JOptionPane
							.showInputDialog("Que desea realizar: \n 1.Jugar \n 2.Crear pregunta\n3.Salir "));
				} catch (Exception e) {
					System.out.println(e);
				}
			} while (opcionJuego < 1 || opcionJuego > 3);

			switch (opcionJuego) {
			case 1:
				jugar();
				break;
			case 2:
				crearPregunta();
				break;
			case 3:
				estado = false;
				break;
			}
		} while (estado);

	}

	public void jugar() {
		crearUsuario();
		int nivel = 1; // nivel de cada pregunta
		int premio = 0; // variable que acumula el premio del jugador
		boolean estadoJuego = false; // determina si el juego termino
		int contador = 0;
		PreguntaView preguntaRonda = null;
		int opcionRespuesta = 0;
		while (nivel <= 5 && estadoJuego == false) {

			Nivel nivelDB = new Nivel();
			List<Nivel> nivels = nivelService.findByNivel(nivel);

			if (nivels.size() > 0)
				nivelDB = nivels.get(0);

			List<Pregunta> preguntasNivel = preguntaService.obtenerPreguntasNivel(nivelDB);

			if (preguntasNivel.size() > 0) {
				preguntaRonda = seleccionarPregunta(preguntasNivel);
				do {
					try {
						opcionRespuesta = Integer.parseInt(JOptionPane.showInputDialog(
								preguntaRonda.getPregunta() + "\n" + preguntaRonda.desplegarRespuestas()
										+ "\n Digite el numero de la opcion correcta: "));
					} catch (Exception e) {
						System.out.println(e);
					}
				} while (opcionRespuesta < 1 || opcionRespuesta > 4);
				if (preguntaRonda.validarRespuesta(opcionRespuesta)) {
					JOptionPane.showMessageDialog(null, "Correto");
					premio += nivel * 3;
					nivel++;
					contador++;
				} else {
					JOptionPane.showMessageDialog(null, "incorrrecto");
					estadoJuego = true;
					registarHistoricoDeJuego(contador, premio, usuario);
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay preguntas para mostrar");
				estadoJuego = true;
			}

		}
		if (contador == 5) {
			registarHistoricoDeJuego(contador, premio, usuario);
		}

	}

	public void crearUsuario() {
		String nombre = "";
		do {
			try {
				nombre = JOptionPane.showInputDialog("Digite su nombre");
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (nombre.length() == 0);

		this.usuario = new Usuario(nombre);
	}

	public PreguntaView seleccionarPregunta(List<Pregunta> preguntas) {
		PreguntaView view = new PreguntaView();
		int valor = 0;

		if (preguntas.size() > 1) {
			System.out.println(
					"Cantidad  de preguntas nivel " + preguntas.get(0).getNivel().getNivel() + ": " + preguntas.size());
			valor = generarNumeroAleatorio(0, preguntas.size() - 1);
			System.out.println("pregunta seleccionada #" + (valor + 1));
		} else
			valor = 0;

		view.setNivelPregunta(preguntas.get(valor).getNivel().getIdNivel());
		view.setPregunta(preguntas.get(valor).getPregunta());

		for (Respuesta respuesta : respuestaService.obtenerRespuestasPregunta(preguntas.get(valor))) {
			RespuestaView respuestaView = new RespuestaView();
			respuestaView.setRespuesta(respuesta.getRespuesta());
			respuestaView.setEstado(respuesta.isEstado());
			view.agregarRespuesta(respuestaView);
		}
		return view;
	}

	public int generarNumeroAleatorio(int minimo, int maximo) {
		Random random = new Random();
		int valor = random.nextInt(maximo + minimo) + minimo;
		return valor;
	}

	public void registarHistoricoDeJuego(int respuestasCorrectas, int premio, Usuario usuario) {
		historicoJuego.add(new HistoricoJuego(respuestasCorrectas, premio, usuario));
		JOptionPane.showMessageDialog(null, "!FIN DEL JUEGO!\n* Respuestas Correctas: " + respuestasCorrectas
				+ "\n* Premio acumulado: " + premio + "\n* Jugador: " + usuario.getNombre());
	}

	public PreguntaService getPreguntaService() {
		return preguntaService;
	}

	public void setPreguntaService(PreguntaService preguntaService) {
		this.preguntaService = preguntaService;
	}

	public NivelService getNivelService() {
		return nivelService;
	}

	public void setNivelService(NivelService nivelService) {
		this.nivelService = nivelService;
	}

	public RespuestaService getRespuestaService() {
		return respuestaService;
	}

	public void setRespuestaService(RespuestaService respuestaService) {
		this.respuestaService = respuestaService;
	}

}
