/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.game.view;
import java.util.ArrayList;
import java.util.List;

public class PreguntaView {
    private long idPregunta;
	private String pregunta;
	private long nivelPregunta;
	List<RespuestaView> respuesta;

	public List<RespuestaView> getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(List<RespuestaView> respuesta) {
		this.respuesta = respuesta;
	}

	public PreguntaView() {
		
		this.respuesta= new ArrayList<>();

	}

	public PreguntaView(String pregunta, long nivelPregunta) {
		super();

		this.pregunta = pregunta;
		this.nivelPregunta = nivelPregunta;
		this.respuesta= new ArrayList<>();
	}

	public long getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public long getNivelPregunta() {
		return nivelPregunta;
	}

	public void setNivelPregunta(long nivelPregunta) {
		this.nivelPregunta = nivelPregunta;
	}

	@Override
	public String toString() {
            String msj = "";
            for (int i = 0; i < this.respuesta.size(); i++) {
                msj += respuesta.get(i).toString()+"\n";
            }
		return "Pregunta [pregunta=" + pregunta + ", nivelPregunta=" + nivelPregunta + "\nrespuestas: "+msj+"]";
	}

	public void agregarRespuesta(RespuestaView res) {
		this.respuesta.add(res);
	}
        
        public String desplegarRespuestas(){
           String respuestas = "";
           for (int i = 0; i < respuesta.size(); i++) {
                respuestas += (i+1)+". "+respuesta.get(i).getRespuesta()+"\n";
            }
            
            return respuestas;
        }
        
        public boolean validarRespuesta(int posicionSeleccionada){
            return respuesta.get(posicionSeleccionada-1).isEstado();
        }
        public int getTamanioRespuestas(){
            return this.respuesta.size();
        }
}
