package com.sofka.game.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_respuesta")
	private long idRespuesta;

	@Column(name = "respuesta")
	private String respuesta;

	@Column(name = "estado")
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	public long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public String toString() {
		return "Respuesta[" + "texto=" + respuesta + ", esCorrecta?=" + estado + ']';
	}
}
