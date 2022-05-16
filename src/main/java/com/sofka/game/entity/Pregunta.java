package com.sofka.game.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pregunta")
public class Pregunta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pregunta")
	private long idPregunta;

	@Column(name = "pregunta")
	private String pregunta;

	@ManyToOne
	@JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
	private Nivel nivel;

	@OneToMany(mappedBy = "respuesta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Respuesta> respuestas;

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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public boolean agregarRespuesta(Respuesta respuesta) {
		return this.respuestas.add(respuesta);
	}

	@Override
	public String toString() {
		String toString = "";
		for (Respuesta respuesta : respuestas) {
			toString += respuesta.toString() + "\n";
		}

		return "Pregunta [enunciado=" + this.pregunta + ", nivel=" + this.nivel.getNivel() + "\nrespuestas: " + toString + "]";
	}

}
