package com.sofka.game.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nivel")
public class Nivel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nivel")
	private Long idNivel;

	@Column(name = "nivel")
	private int nivel;

	@Column(name = "premio")
	private int premio;

	@OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pregunta> preguntas;

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

}
